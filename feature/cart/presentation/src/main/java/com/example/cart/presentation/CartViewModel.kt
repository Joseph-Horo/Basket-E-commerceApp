package com.example.cart.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cart.domain.model.ProductCart
import com.example.cart.domain.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: CartRepository
): ViewModel() {

    var state by mutableStateOf(CartState())

    init {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            val cart = repository.getCart()
            state = state.copy(
                cart = cart,
                isLoading = false
            )
        }
    }

    fun removeFromCart(cart: ProductCart) {
        viewModelScope.launch {
            repository.removeFromCart(cart)
            val cart = repository.getCart()
            state = state.copy(
                cart = cart
            )
        }
    }

    fun increaseQuantity(id: Int){
        viewModelScope.launch {
            repository.increaseQuantity(id)
            val cart = repository.getCart()
            state = state.copy(
                cart = cart
            )
        }

    }

    fun decreaseQuantity(id: Int){
        viewModelScope.launch {
            repository.decreaseQuantity(id)
            val cart = repository.getCart()
            state = state.copy(
                cart = cart
            )
        }
    }


}