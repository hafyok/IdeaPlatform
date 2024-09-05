package com.example.ideaplatform.Domain

data class Item(
    val id: Int,
    val name: String,
    val time: Int,
    val tags: List<String>,
    val amount: Int
)
