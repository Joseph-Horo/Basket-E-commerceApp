package com.example.home.presentation

import com.example.home.domain.model.ProductItem

data class HomeState(
    val products: List<ProductItem> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)
