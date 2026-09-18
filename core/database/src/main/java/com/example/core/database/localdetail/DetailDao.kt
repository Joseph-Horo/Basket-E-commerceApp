package com.example.core.database.localdetail

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductsDetails(detailProducts: List<DetailEntity>)
    @Query("SELECT * FROM detailentity WHERE id = :id")
    suspend fun getProductDetail(id: Int): DetailEntity
}