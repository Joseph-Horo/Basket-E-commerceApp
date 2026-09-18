package com.example.explore.domain.repository

import com.example.explore.domain.model.Product

interface ExploreRepository {
    suspend fun insertProducts()
    suspend fun getProducts(): List<Product>
    suspend fun searchProducts(query: String): List<Product>
}