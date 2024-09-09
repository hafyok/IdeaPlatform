package com.example.ideaplatform.Data

import androidx.room.TypeConverter

class Converters {

    // Преобразуем строку в список
    @TypeConverter
    fun fromStringToList(value: String): List<String> {
        return value.split(",").map { it.trim() }
    }

    // Преобразуем список в строку
    @TypeConverter
    fun fromListToString(list: List<String>): String {
        return list.joinToString(",")
    }
}