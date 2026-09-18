package com.example.details.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.details.data.mapper.toProductCart
import com.example.details.domain.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){
    var state by mutableStateOf(DetailState())

    init {
        viewModelScope.launch {
            val id = savedStateHandle.get<Int>("id") ?: return@launch
            state = state.copy(
                isLoading = true
            )
            repository.insertProductsDetails()
            val detail = repository.getProductDetail(id)
            state = state.copy(
                detail = detail,
                isLoading = false
            )
            repository.isInCart(id)
                .collect { isInCart->
                    state = state.copy(
                        isInCart = isInCart
                    )
                }
        }
    }
    fun addToCart(quantity: Int = 1){
        state.detail?.let { product->
            viewModelScope.launch {
                repository.addToCart(product.toProductCart(quantity))
            }

        }
    }


}