package com.example.core.database.localdetail

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class DetailEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val category: String,
    val image: String,
    val price: Double,
    val description: String
)
