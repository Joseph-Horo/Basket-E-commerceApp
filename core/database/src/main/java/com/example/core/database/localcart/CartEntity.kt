package com.example.core.database.localcart

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class CartEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val image: String,
    val price: Double,
    val quantity: Int
)
