package com.example.explore.data.mapper

import com.example.core.database.localproduct.ProductEntity
import com.example.explore.domain.model.Product

fun ProductEntity.toProduct(): Product{
    return Product(
        id = id,
        name = name,
        category = category,
        image = image,
        price = price
    )
}
fun Product.toProductEntity(): ProductEntity{
    return ProductEntity(
        id = id,
        name = name,
        category = category,
        image = image,
        price = price
    )
}
