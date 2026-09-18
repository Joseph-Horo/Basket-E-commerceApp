package com.example.home.data.repository

import com.example.core.database.BasketDatabase
import com.example.core.database.localproduct.ProductData
import com.example.home.data.mapper.toProductItem
import com.example.home.domain.model.ProductItem
import com.example.home.domain.repository.HomeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl  @Inject constructor(
    private val db: BasketDatabase
): HomeRepository{
    private val productDao = db.productDao
    override suspend fun insertProducts() {
       productDao.insertProducts(ProductData.products)
    }

    override suspend fun getProducts(): List<ProductItem> {
    return productDao.getProducts().map { it.toProductItem() }
    }

    override suspend fun getProductByCategory(category: String): List<ProductItem> {
        return productDao.getProductByCategory(category).map { it.toProductItem() }
      }


    }
