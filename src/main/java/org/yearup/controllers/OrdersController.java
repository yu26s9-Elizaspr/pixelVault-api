package org.yearup.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yearup.models.Orders;
import org.yearup.models.User;
import org.yearup.service.OrdersService;
import org.yearup.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/orders")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class OrdersController {

    private final OrdersService ordersService;
    private final UserService userService;

    public OrdersController (OrdersService ordersService, UserService userService){
        this.ordersService = ordersService;
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Orders> checkout (Principal principal) {
        String userName = principal.getName();
        User user = userService.getByUserName(userName);

        Orders orders = ordersService.checkout(user.getId());

        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

}
