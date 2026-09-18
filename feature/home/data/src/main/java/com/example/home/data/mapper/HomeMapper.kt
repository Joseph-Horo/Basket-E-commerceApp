package com.example.home.data.mapper

import com.example.core.database.localproduct.ProductEntity
import com.example.home.domain.model.ProductItem

fun ProductEntity.toProductItem(): ProductItem{
    return ProductItem(
        id = id,
        name = name,
        category = category,
        image = image,
        price = price
    )
}
fun ProductItem.toProductEntity(): ProductEntity{
    return ProductEntity(
        id = id,
        name = name,
        category = category,
        image = image,
        price = price
    )
}
