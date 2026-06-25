# pixelVault-api
This is the final Capstone for the Java Software Class through the Year Up Program. 

This is a full - stack REST API built with Springboot, JPA, and MYSQL. The application allows users to browse products, add things to their cart, update their profile, and complete the checkout process. Admin can manage products and categories through secured endpoints. 

## Features 

##Authentification 
- User registration
- User login
- Role based authorization (Admin or User)

##Products
- View all products 
- Search by category
- Filer by Price 
- Filter by subcategory (Genre)

<img width="334" height="579" alt="Screenshot 2026-06-25 at 5 10 36 PM" src="https://github.com/user-attachments/assets/1a9b7083-5d4c-4455-862d-2f6e73457bbf" />

## Shopping Cart 
- View current cart
- Add items to cart
- Clear cart
- Change Quantity of items in cart
<img width="1249" height="423" alt="Screenshot 2026-06-25 at 5 07 07 PM" src="https://github.com/user-attachments/assets/69175ff0-b56b-4ee6-9db3-a2cd081c5d1d" />

##User Profile 
- View Profile
- Change profile information
<img width="1187" height="690" alt="Screenshot 2026-06-25 at 5 06 28 PM" src="https://github.com/user-attachments/assets/4d2ea89b-0fd3-4b49-ade0-18006485ed28" />

  
##Checkout 
- Create orders from cart
- Save order info
- Clear cart after successful purchase

<img width="1236" height="540" alt="Screenshot 2026-06-25 at 5 07 14 PM" src="https://github.com/user-attachments/assets/ba9a748e-40df-4fbf-a049-b1694d2dda5b" />



## API Endpoints

| Method | Endpoint |
|---------|----------|
| POST | /login |
| POST | /register |

### Products

| Method | Endpoint |
|---------|----------|
| GET | /products |
| GET | /products/{id} |
| POST | /products |
| PUT | /products/{id} |
| DELETE | /products/{id} |

### Categories

| Method | Endpoint |
|---------|----------|
| GET | /categories |
| GET | /categories/{id} |
| POST | /categories |
| PUT | /categories/{id} |
| DELETE | /categories/{id} |

### Shopping Cart

| Method | Endpoint |
|---------|----------|
| GET | /cart |
| POST | /cart/products/{productId} |
| PUT | /cart/products/{productId} |
| DELETE | /cart |

### Profile

| Method | Endpoint |
|---------|----------|
| GET | /profile |
| PUT | /profile |

### Orders

| Method | Endpoint |
|---------|----------|
| POST | /orders |

## Running the Project 
1. Clone the Github repository and open in Intellij
2. Create MySQL database and run the provided SQL script
3. Update username and password in 'application.properties'
4. Run the Application.
5. Access the API using your local server. 


