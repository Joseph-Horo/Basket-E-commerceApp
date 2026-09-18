package com.example.explore.presentation

import com.example.explore.domain.model.Product

data class ExploreState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = ""
)
