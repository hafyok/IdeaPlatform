package com.example.ideaplatform.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ItemRoomDatabase : RoomDatabase() {
    abstract val dao: ItemDao

}