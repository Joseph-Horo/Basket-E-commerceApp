package com.example.details.domain.repository

import com.example.details.domain.model.ProductCart
import com.example.details.domain.model.ProductDetail
import kotlinx.coroutines.flow.Flow

interface DetailRepository {
    suspend fun getProductDetail(id: Int): ProductDetail
    suspend fun insertProductsDetails()
    suspend fun addToCart(cart: ProductCart)
    fun isInCart(id: Int): Flow<Boolean>
}