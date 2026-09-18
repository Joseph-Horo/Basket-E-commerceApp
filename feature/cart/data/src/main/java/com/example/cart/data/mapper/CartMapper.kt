package com.example.cart.data.mapper

import com.example.cart.domain.model.ProductCart
import com.example.core.database.localcart.CartEntity

fun CartEntity.toProductCart(): ProductCart{
    return ProductCart(
        id = id,
        name = name,
        image = image,
        price = price,
        quantity = quantity
    )
}
fun ProductCart.toCartEntity(): CartEntity{
    return CartEntity(
        id = id,
        name = name,
        image = image,
        price = price,
        quantity = quantity
    )
}
