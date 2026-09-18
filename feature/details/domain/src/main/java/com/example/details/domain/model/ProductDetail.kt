package com.example.details.domain.model

data class ProductDetail(
    val id: Int,
    val name: String,
    val image: String,
    val category: String,
    val price: Double,
    val description: String
)
