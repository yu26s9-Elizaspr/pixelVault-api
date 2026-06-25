package org.yearup.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.yearup.models.*;
import org.yearup.repository.OrderLineItemRepository;
import org.yearup.repository.OrdersRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderLineItemRepository orderLineItemRepository;
    private final ShoppingCartService shoppingCartService;
    private final ProfileService profileService;

    public OrdersService(OrdersRepository ordersRepository, OrderLineItemRepository orderLineItemRepository,
                         ShoppingCartService shoppingCartService, ProfileService profileService) {
        this.ordersRepository = ordersRepository;
        this.orderLineItemRepository = orderLineItemRepository;
        this.shoppingCartService = shoppingCartService;
        this.profileService = profileService;
    }

    @Transactional
    public Orders checkout(int userId) {
        ShoppingCart cart = shoppingCartService.getByUserId(userId);
        Profile profile = profileService.getByUserId(userId);

        Orders order = new Orders();
        order.setUserId(userId);
        order.setDate(LocalDateTime.now());
        order.setAddress(profile.getAddress());
        order.setCity(profile.getCity());
        order.setState(profile.getState());
        order.setZip(profile.getZip());
        order.setShippingAmount(BigDecimal.ZERO);

        Orders savedOrders = ordersRepository.save(order);

        for (ShoppingCartItem cartItem : cart.getItems().values()) {

            OrderLineItem lineItem = new OrderLineItem();
            lineItem.setOrderId(savedOrders.getOrderId());
            lineItem.setProductId(cartItem.getProduct().getProductId());
            lineItem.setSalesPrice(BigDecimal.valueOf(cartItem.getProduct().getPrice()));
            lineItem.setQuantity(cartItem.getQuantity());
            lineItem.setDiscount(BigDecimal.valueOf(cartItem.getDiscountPercent()));

            orderLineItemRepository.save(lineItem);

        }


        shoppingCartService.clearCart(userId);
        return savedOrders;

    }
}
