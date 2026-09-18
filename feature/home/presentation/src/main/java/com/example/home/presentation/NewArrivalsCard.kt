package com.example.home.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NewArrivalsCard(
    navController: NavController
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .height(170.dp)
            .padding(10.dp)
            .clickable{
                navController.navigate("explore")
            },
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
       horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 40.dp, top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("New Arrivals ✨",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White
            )

            Text("Discover Our Latest Products",
                fontStyle = FontStyle.Italic,
                fontSize = 23.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFFB343)

            )
            Text("Shop Now ‼️",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )


        }
    }

}