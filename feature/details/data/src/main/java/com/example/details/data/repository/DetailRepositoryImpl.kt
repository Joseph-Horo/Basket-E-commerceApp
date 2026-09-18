package com.example.details.data.repository

import com.example.core.database.BasketDatabase
import com.example.core.database.localdetail.DetailProductData
import com.example.details.data.mapper.toCartEntity
import com.example.details.data.mapper.toProductDetail
import com.example.details.domain.model.ProductCart
import com.example.details.domain.model.ProductDetail
import com.example.details.domain.repository.DetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailRepositoryImpl @Inject constructor(
    private val db: BasketDatabase
): DetailRepository {
    private val detailDao = db.detailDao
    private val cartDao = db.cartDao
    override suspend fun getProductDetail(id: Int): ProductDetail {
              return detailDao.getProductDetail(id).toProductDetail()
    }

    override suspend fun insertProductsDetails() {
       detailDao.insertProductsDetails(DetailProductData.detailProducts)
    }

    override suspend fun addToCart(cart: ProductCart) {
     cartDao.insertToCart(cart.toCartEntity())
    }

    override fun isInCart(id: Int): Flow<Boolean> {
   return cartDao.isInCart(id)
    }
}