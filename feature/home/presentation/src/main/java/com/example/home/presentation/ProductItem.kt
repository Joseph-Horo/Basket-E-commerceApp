package com.example.home.presentation

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
import com.example.core.ui.mapper.getProductImage
import com.example.home.domain.model.ProductItem

@Composable
fun ProductItem(
    item: ProductItem,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .clickable(onClick = onClick)

    ) {
        Image(painterResource(getProductImage(item.image)),
            contentDescription = item.name,
            modifier = Modifier.size(180.dp))
        Text(text = item.name)
        Text("$${item.price}")

    }

}