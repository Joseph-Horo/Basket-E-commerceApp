package com.example.cart.data.repository

import com.example.cart.data.mapper.toCartEntity
import com.example.cart.data.mapper.toProductCart
import com.example.cart.domain.model.ProductCart
import com.example.cart.domain.repository.CartRepository
import com.example.core.database.BasketDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartRepositoryImpl @Inject constructor(
    private val db: BasketDatabase
): CartRepository {
    private val cartDao = db.cartDao
    override suspend fun getCart(): List<ProductCart> {
          return cartDao.getCart().map { it.toProductCart() }
    }

    override suspend fun removeFromCart(cart: ProductCart) {
        cartDao.deleteProduct(cart.toCartEntity())
    }

    override suspend fun increaseQuantity(id: Int) {
       cartDao.increaseQuantity(id)
    }

    override suspend fun decreaseQuantity(id: Int) {
       cartDao.decreaseQuantity(id)
    }
}