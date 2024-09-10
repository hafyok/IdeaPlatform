package com.example.ideaplatform.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao{
    @Query("SELECT * FROM ItemEntity")
    suspend fun getItems(): List<ItemEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: ItemEntity)

    @Query("DELETE FROM ItemEntity WHERE id = :itemId")
    fun deleteItemById(itemId: Int)
}

