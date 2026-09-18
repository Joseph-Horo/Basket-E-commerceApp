package com.example.core.database.localproduct

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val category: String,
    val image: String,
    val price: Double
)
