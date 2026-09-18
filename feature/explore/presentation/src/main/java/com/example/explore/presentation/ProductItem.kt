package com.example.explore.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core.ui.mapper.getProductImage
import com.example.explore.domain.model.Product

@Composable
fun ProductItem(
    product: Product,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .clickable(onClick = onClick)

    ) {
        Image(painterResource(getProductImage(product.image)),
            contentDescription = product.name,
            modifier = Modifier.size(180.dp))
        Text(text = product.name)
        Text("$${product.price}")

    }

}