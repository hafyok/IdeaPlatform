package com.example.ideaplatform.Data

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ItemDatabaseCallback(
    private val scope: CoroutineScope
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        // Здесь мы получаем базу данных и itemDao только после её создания
        val database = ItemRoomDatabase.INSTANCE
        val itemDao = database?.itemDao()

        if (itemDao != null) {
            scope.launch {
                populateDatabase(itemDao)
            }
        }
    }

    // Функция для добавления данных
    suspend fun populateDatabase(itemDao: ItemDao) {
        mockData.forEach { item ->
            itemDao.insert(item)
        }
    }
}