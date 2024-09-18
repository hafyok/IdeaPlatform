package com.example.ideaplatform.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "item")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int
)
