package com.example.details.domain.model

data class ProductCart(
    val id: Int,
    val name: String,
    val image: String,
    val price: Double,
    val quantity: Int
)