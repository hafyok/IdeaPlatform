package com.example.ideaplatform.Data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ItemRepository(private val itemDao: ItemDao){
    var allItems: List<ItemEntity> = emptyList()

    suspend fun fetchAllItems() {
        allItems = itemDao.getItems()
    }

    suspend fun removeItemById(id: Int){
        withContext(Dispatchers.IO){
            itemDao.deleteItemById(id)
        }
    }
}

