package com.zali.tripsearcher.domain.model

data class ContentMain(
    val `data`: List<Data>
)

data class Data(
    val items: List<Item>,
    val title: String,
    val type: String
)

data class Item(
    val action: String,
    val action_link: String,
    val id: Int,
    val locations: Int,
    val people: List<String>,
    val photo: String,
    val price: Int,
    val rate: Double,
    val title: String
)