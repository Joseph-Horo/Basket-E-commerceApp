package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.database.localcart.CartDao
import com.example.core.database.localcart.CartEntity
import com.example.core.database.localdetail.DetailDao
import com.example.core.database.localdetail.DetailEntity
import com.example.core.database.localproduct.ProductDao
import com.example.core.database.localproduct.ProductEntity

@Database(
    entities = [
        ProductEntity::class,
        DetailEntity::class,
        CartEntity::class

    ],
    version = 1
)
abstract class BasketDatabase: RoomDatabase() {
    abstract val productDao: ProductDao
    abstract val detailDao: DetailDao
    abstract val cartDao: CartDao
}