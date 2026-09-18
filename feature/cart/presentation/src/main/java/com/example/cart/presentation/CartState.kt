package com.example.cart.presentation

import com.example.cart.domain.model.ProductCart

data class CartState(
    val cart: List<ProductCart> = emptyList(),
    val isLoading: Boolean = false
)
