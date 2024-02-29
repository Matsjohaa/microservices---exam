
-product: POST http://localhost:8080/api/products
```
{
"productName": "iphone 15",
"productDescription": "a newer iphone",
"productPrice": 9990,
"productStock": 200
},
{
"productName": "playstation 5",
"productDescription": "a device for playing games",
"productPrice": 5000,
"productStock": 57
}
```

-user: POST http://localhost:8081/api/users

```
{
    "userName": "newUser",
    "email": "newUser@example.com",
    "password": "securePassword",
    "role": "User"
}
```

-order: POST http://localhost:8082/api/orders
```
{
  "userId": "1",
  "orderItems": [
    {
      "productId": "1",
      "quantity": 2
    },
    {
      "productId": "2",
      "quantity": 1
    }
  ]
}

```