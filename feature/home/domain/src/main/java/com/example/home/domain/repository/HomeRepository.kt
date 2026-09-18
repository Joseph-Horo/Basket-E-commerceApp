package com.example.home.domain.repository

import com.example.home.domain.model.ProductItem

interface HomeRepository {
    suspend fun insertProducts()
    suspend fun getProducts(): List<ProductItem>
    suspend fun getProductByCategory(category: String): List<ProductItem>
}