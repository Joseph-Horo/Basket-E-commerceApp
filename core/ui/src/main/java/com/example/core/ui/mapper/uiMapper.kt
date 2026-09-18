package com.example.core.ui.mapper

import com.example.core.ui.R


fun getProductImage(image: String): Int{
    return when (image){
        "yellow_hood" -> R.drawable.yellow_hood
        "smart_watch" -> R.drawable.smart_watch
        "red_sweater" -> R.drawable.red_sweater
        "refurbished_laptop" -> R.drawable.refurbished_laptop
        "sport_shoes" -> R.drawable.sport_shoes
        "unisex_shoes" -> R.drawable.unisex_shoes
        "round_table" -> R.drawable.round_table
        "pink_dress" -> R.drawable.pink_dress
        "long_dress" -> R.drawable.long_dress
        "winter_shoes" -> R.drawable.winter_shoes
        "gold_coated_earings" -> R.drawable.gold_coated_necklace
        "cotton_scarf" -> R.drawable.cotton_scarf
        "foot_ball" -> R.drawable.foot_ball
        "cap" -> R.drawable.cap
        "brown_leather_watch" -> R.drawable.brown_leather_watch
        "blue_jacket" -> R.drawable.blue_jacket
        "basket_ball" -> R.drawable.basket_ball
        "blue_leather_watch" -> R.drawable.blue_leather_watch
        "black_tshirt" -> R.drawable.black_tshirt
        "designer_shoes" -> R.drawable.designer_shoes
        "gold_coated_necklace" -> R.drawable.gold_coated_necklace
        "green_leather_watch" -> R.drawable.green_leather_watch
        "ladies_boots" -> R.drawable.ladies_boots
        "ladies_shoes" -> R.drawable.ladies_shoes
        "living_room_table" -> R.drawable.living_room_table
        "official_men_watch" -> R.drawable.official_men_watch
        "refurbished_phone" -> R.drawable.refurbished_phone
        "rubber_shoes" -> R.drawable.rubber_shoes
        "yellow_tshirt" -> R.drawable.yellow_tshirt
        else -> R.drawable.placeholder
    }
}