package com.example.ideaplatform.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao{
    @Query("SELECT * FROM ItemEntity")
    fun getItems(): Flow<List<ItemEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: ItemEntity)

    @Query("DELETE FROM ItemEntity WHERE id = :itemId")
    fun deleteItemById(itemId: Int)

    @Query("UPDATE ItemEntity SET amount = :newAmount WHERE id = :itemId")
    suspend fun updateAmountById(itemId: Int, newAmount: Int)
}

