package com.example.ideaplatform.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
abstract class ItemRoomDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object{
        @Volatile
        private var INSTANCE: ItemRoomDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): ItemRoomDatabase{
            return INSTANCE ?: synchronized(LOCK){
                INSTANCE ?: BuildDatabase(context).also {
                    INSTANCE == it
                }
            }
        }
        private fun BuildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, ItemRoomDatabase::class.java, "ItemDB").build()

    }
}
