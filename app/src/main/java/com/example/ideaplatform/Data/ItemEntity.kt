package com.example.ideaplatform.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val time: Int,
    val tags: String,
    val amount: Int
)
