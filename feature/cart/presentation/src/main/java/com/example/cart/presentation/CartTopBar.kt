package com.example.cart.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartTopBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = { Text("Cart") },
        scrollBehavior = scrollBehavior
    )

}