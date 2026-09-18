package com.example.explore.data.repository

import com.example.core.database.BasketDatabase
import com.example.core.database.localproduct.ProductData
import com.example.explore.data.mapper.toProduct
import com.example.explore.domain.model.Product
import com.example.explore.domain.repository.ExploreRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExploreRepositoryImpl @Inject  constructor(
    private val db: BasketDatabase
): ExploreRepository{
    private val productDao = db.productDao
    override suspend fun insertProducts() {
       productDao.insertProducts(ProductData.products)
    }

    override suspend fun getProducts(): List<Product> {
        return productDao.getProducts().map { it.toProduct() }
    }

    override suspend fun searchProducts(query: String): List<Product> {
      return productDao.searchProducts(query).map { it.toProduct() }
    }
}