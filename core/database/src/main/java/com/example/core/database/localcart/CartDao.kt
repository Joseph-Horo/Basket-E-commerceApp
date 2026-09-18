package com.example.core.database.localcart

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToCart(cart: CartEntity)
    @Delete
    suspend fun deleteProduct(product: CartEntity)
    @Query("SELECT * FROM cartentity")
    suspend fun getCart(): List<CartEntity>
    @Query("SELECT EXISTS(SELECT 1 FROM cartentity WHERE id = :id)")
    fun isInCart(id: Int): Flow<Boolean>
    @Query("UPDATE cartentity SET quantity = quantity + 1 WHERE id = :id")
    suspend fun increaseQuantity(id: Int)
    @Query("UPDATE cartentity SET quantity = quantity - 1 WHERE id = :id")
    suspend fun decreaseQuantity(id: Int)
}