package com.example.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {
    var state by mutableStateOf(HomeState())

    init {
        viewModelScope.launch {
            repository.insertProducts()
            getProducts()
        }
    }

    private suspend fun getProducts(){
            state = state.copy(
                isLoading = true
            )
            val products = repository.getProducts()
            state = state.copy(
                products = products,
                isLoading = false
            )

    }
    fun getProductByCategory(category: String){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            val products = repository.getProductByCategory(category)
            state = state.copy(
                products = products,
                isLoading = false
            )
        }
    }


}