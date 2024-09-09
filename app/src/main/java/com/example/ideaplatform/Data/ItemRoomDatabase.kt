package com.example.ideaplatform.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlinx.coroutines.CoroutineScope

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ItemRoomDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        var INSTANCE: ItemRoomDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context, scope: CoroutineScope): ItemRoomDatabase {
            return INSTANCE ?: synchronized(LOCK) {
                INSTANCE ?: buildDatabase(context, scope).also {
                    INSTANCE = it
                }
            }
        }

        private fun buildDatabase(context: Context, scope: CoroutineScope): ItemRoomDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ItemRoomDatabase::class.java,
                "ItemDB"
            )
                .addCallback(ItemDatabaseCallback(scope))
                .build()
        }
    }
}