package com.example.ideaplatform.Data


class ItemRepository(private val itemDao: ItemDao){
    var allItems: List<ItemEntity> = emptyList()

    suspend fun fetchAllItems() {
        allItems = itemDao.getItems()
    }
}

