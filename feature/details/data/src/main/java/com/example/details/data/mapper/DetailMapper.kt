package com.example.details.data.mapper

import com.example.core.database.localcart.CartEntity
import com.example.core.database.localdetail.DetailEntity
import com.example.details.domain.model.ProductCart
import com.example.details.domain.model.ProductDetail

fun DetailEntity.toProductDetail(): ProductDetail{
    return ProductDetail(
        id = id,
        name = name,
        image = image,
        category = category,
        price = price,
        description = description
    )
}
fun ProductDetail.toDetailEntity(): DetailEntity{
    return DetailEntity(
        id = id,
        name = name,
        image = image,
        category = category,
        price = price,
        description = description
    )
}
fun ProductDetail.toCartEntity(quantity: Int = 1): CartEntity{
    return CartEntity(
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
fun ProductDetail.toProductCart(quantity: Int = 1): ProductCart{
    return ProductCart(
        id = id,
        name = name,
        image = image,
        price = price,
        quantity = quantity
    )

}
