package com.example.ideaplatform.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao{
    @Query("SELECT * FROM item")
    fun getItems(): Flow<List<ItemEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: ItemEntity)

    @Query("DELETE FROM item WHERE id = :itemId")
    fun deleteItemById(itemId: Int)

    @Query("UPDATE item SET amount = :newAmount WHERE id = :itemId")
    suspend fun updateAmountById(itemId: Int, newAmount: Int)
}

