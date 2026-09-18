package com.example.home.presentation

sealed class HomeEvent {
    data class OnSearchQueryChange( val query: String): HomeEvent()
}