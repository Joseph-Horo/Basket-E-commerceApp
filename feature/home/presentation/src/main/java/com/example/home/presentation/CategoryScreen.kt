package com.example.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CategoryScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
    category: String
) {
   LaunchedEffect(category) {
       viewModel.getProductByCategory(category)

    }
    val state = viewModel.state
    if (state.isLoading){
        CircularProgressIndicator()
    }else{
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(state.products){product->
                ProductItem(
                    item = product,
                    onClick = {
                        navController.navigate("details/${product.id}")
                    }
                )

            }
        }
    }

        }


