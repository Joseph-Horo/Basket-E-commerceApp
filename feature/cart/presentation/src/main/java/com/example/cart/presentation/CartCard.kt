package com.example.cart.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cart.domain.model.ProductCart
import com.example.core.ui.mapper.getProductImage

@Composable
fun CartCard(
    product: ProductCart,
    viewModel: CartViewModel
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()

        ) {
            Image(painterResource(getProductImage(product.image)),
                contentDescription = product.name,
                modifier = Modifier.size(150.dp)
                )
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(text = product.name,
                    fontWeight = FontWeight.SemiBold)
                Text("$${product.price}",
                    fontStyle = FontStyle.Italic)
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                            viewModel.decreaseQuantity(product.id)
                        }
                    ) {
                        Text("-")
                    }
                    Text(text = "${product.quantity}")
                    IconButton(
                        onClick = {
                            viewModel.increaseQuantity(product.id)
                        }
                    ) {
                        Text("+")
                    }

                }
                TextButton(
                    onClick = {
                        viewModel.removeFromCart(product)
                    }
                ) {
                    Text("Remove")
                }


            }

        }
    }

}