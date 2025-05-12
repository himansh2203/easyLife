package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.CartItem;



@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React
public class CartController {

    private final List<CartItem> cartItems = new ArrayList<>();

    // Initialize with some dummy data
    public CartController() {
        cartItems.add(new CartItem(1, "Product 1", 10.0, 1));
        cartItems.add(new CartItem(2, "Product 2", 15.0, 2));
    }

    @GetMapping
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @PostMapping
    public CartItem addCartItem(@RequestBody CartItem item) {
        cartItems.add(item); // Add the item to the in-memory list
        return item; // Return the added item
    }

    @PutMapping("/{id}")
    public CartItem updateCartItem(@PathVariable int id, @RequestBody CartItem updatedItem) {
        for (CartItem item : cartItems) {
            if (item.getId() == id) {
                item.setQuantity(updatedItem.getQuantity());
                return item;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found");
    }

    @DeleteMapping("/{id}")
    public void removeCartItem(@PathVariable int id) {
        cartItems.removeIf(item -> item.getId() == id);
    }
}
