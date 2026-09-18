package com.example.explore.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ExploreScreen(
    navController: NavController,
    viewModel: ExploreViewModel = hiltViewModel()
    ) {
    val state = viewModel.state
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        BasicTextField(
            value = state.searchQuery,
            onValueChange = {newQuery->
                viewModel.onEvent(ExploreEvent.OnSearchQueryChange(query = newQuery))
            },
            modifier = Modifier.fillMaxWidth()
                .size(60.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFFE2E8F0)),
            textStyle = TextStyle(fontSize = 24.sp),
            decorationBox = {innerTextField->
                Box(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (state.searchQuery.isBlank()){
                        Text("Search Products")
                    }
                    innerTextField()
                }
            }
        )
        if (state.isLoading){
            CircularProgressIndicator()
        }else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize(),
            ) {
                items(state.products){product->
                    ProductItem(
                        product = product,
                        onClick = {
                            navController.navigate("details/${product.id}")
                        }

                    )

                }
            }
        }

    }

}