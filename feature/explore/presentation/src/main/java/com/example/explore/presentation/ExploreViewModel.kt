package com.example.explore.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.explore.domain.repository.ExploreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val repository: ExploreRepository
): ViewModel() {

    var state by mutableStateOf(ExploreState())
    private var searchJob: Job? = null
    init {
        viewModelScope.launch {
            repository.insertProducts()
            getProducts()
        }
    }

    fun onEvent(event: ExploreEvent){
        when(event){
            is ExploreEvent.OnSearchQueryChange -> {
                state = state.copy(
                    searchQuery = event.query
                )
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500.milliseconds)

                    if (event.query.isBlank()){
                        getProducts()
                    }else{
                        val products = repository.searchProducts(event.query)
                        state = state.copy(
                            products = products,
                            isLoading = false
                        )
                    }
                }

            }
        }
    }
    private suspend fun getProducts(){
        state  = state.copy(
            isLoading = true
        )
        val products = repository.getProducts()
        state = state.copy(
            products = products,
            isLoading = false
        )
    }
}