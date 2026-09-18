package com.example.details.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core.ui.mapper.getProductImage

@Composable
fun DetailsScreen(
    navController: NavController,
viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.state
    if (state.isLoading){
        CircularProgressIndicator()
    }else{
        state.detail?.let { detail->
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(10.dp)
            ) {
                Image(
                    painterResource(getProductImage(detail.image)),
                    contentDescription = detail.name,
                    modifier = Modifier.fillMaxWidth()
                        .height(300.dp)
                    )
                Text(text = detail.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)
                Text("$${detail.price}",
                    fontStyle = FontStyle.Italic)
                Text(detail.description)

                Button(
                    onClick = {
                        if (!state.isInCart){
                            viewModel.addToCart(quantity = detail.id)
                        }
                    },
                    enabled = !state.isInCart,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFB343))
                ) {
                    Text(if (state.isInCart){
                        "isInCart"
                    }else{
                        "AddToCart"
                    })
                }
            }
        }
    }

}