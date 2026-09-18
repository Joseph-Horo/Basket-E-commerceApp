package com.example.cart.domain.repository

import com.example.cart.domain.model.ProductCart

interface CartRepository {
    suspend fun getCart(): List<ProductCart>
    suspend fun removeFromCart(cart: ProductCart)
    suspend fun increaseQuantity(id: Int)
    suspend fun decreaseQuantity(id: Int)
}