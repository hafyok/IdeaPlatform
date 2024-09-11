package com.example.ideaplatform.Data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class ItemRepository(private val itemDao: ItemDao){
    var allItems: Flow<List<ItemEntity>> = itemDao.getItems()

    /*suspend fun fetchAllItems() {
        allItems = itemDao.getItems()
    }*/

    suspend fun removeItemById(id: Int){
        withContext(Dispatchers.IO){
            itemDao.deleteItemById(id)
        }
    }

    suspend fun updateAmount(id: Int, newAmount: Int) {
        withContext(Dispatchers.IO) {
            itemDao.updateAmountById(id, newAmount)
        }
    }
}

