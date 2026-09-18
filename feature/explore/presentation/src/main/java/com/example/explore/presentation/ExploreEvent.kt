package com.example.explore.presentation

sealed class ExploreEvent {
    data class OnSearchQueryChange(val query: String): ExploreEvent()
}