package com.example.details.presentation

import com.example.details.domain.model.ProductDetail

data class DetailState(
    val detail: ProductDetail? = null,
    val isLoading: Boolean = false,
    val isInCart: Boolean = false,
)
