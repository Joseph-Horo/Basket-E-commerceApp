package com.example.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core.ui.R


@Composable
fun CategorySection(
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryItem(
                image = R.drawable.clothes_category,
                name = "Clothes",
                onClick = {
                    navController.navigate("category/clothes")
                }
            )
            CategoryItem(
                image = R.drawable.shoes_category,
                name = "Shoes",
                onClick = {
                    navController.navigate("category/shoes")
                }
            )
            CategoryItem(
                image = R.drawable.jewellery_category,
                name = "Jewellery",
                onClick = {
                    navController.navigate("category/jewellery")
                }
            )

        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            CategoryItem(
                image = R.drawable.watch_category,
                name = "Watch",
                onClick = {
                    navController.navigate("category/watches")
                }
            )
            CategoryItem(
                image = R.drawable.furniture_category,
                name = "Furniture",
                onClick = {
                    navController.navigate("category/furniture")
                }
            )
            CategoryItem(
                image = R.drawable.sports_category,
                name = "Sports",
                onClick = {
                    navController.navigate("category/sports")
                }
            )
        }
    }
}

@Composable
private fun CategoryItem(
    image: Int,
    name: String,

    onClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(image),
            contentDescription = name,
            modifier = Modifier
                .size(90.dp)
                .clickable { onClick() }
        )
        Text(text = name)

    }

}