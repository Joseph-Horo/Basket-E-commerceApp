package com.example.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state
    if (state.isLoading){
        CircularProgressIndicator()
    }else{
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            item (span = { GridItemSpan(maxLineSpan)}){
                Text("Featured",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)
            }
            item (span = { GridItemSpan(maxLineSpan)}){
                NewArrivalsCard(
                    navController = navController
                )
            }
            item(span = {GridItemSpan(maxLineSpan)}) {
                Text("Category",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)
            }
            item(span = { GridItemSpan(maxLineSpan)}){
                CategorySection(
                    navController = navController
                )

            }
            item (span = { GridItemSpan(maxLineSpan)}){
                Text("Popular Picks",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)
            }
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