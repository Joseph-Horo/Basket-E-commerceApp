package com.example.core.database.localproduct

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Query("SELECT * FROM productentity")
    suspend fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM productentity WHERE category = :category")
    suspend fun getProductByCategory(category: String): List<ProductEntity>

    @Query("SELECT * FROM productentity WHERE name LIKE '%' || :query || '%'")
    suspend fun searchProducts(query: String): List<ProductEntity>
}