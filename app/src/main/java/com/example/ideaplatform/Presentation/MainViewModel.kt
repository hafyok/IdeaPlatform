package com.example.ideaplatform.Presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ideaplatform.Data.ItemDao
import com.example.ideaplatform.Data.ItemEntity
import com.example.ideaplatform.Data.ItemRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application, itemDao: ItemDao): AndroidViewModel(application){
    private val repository = ItemRepository(itemDao)
    val _items: List<ItemEntity> = repository.allItems


    init {
        //val itemDao = ItemRoomDatabase.getDatabase(application).itemDao()
        //epository = ItemRepository(itemDao)
        //allItems = repository.allItems
    }

    fun getItems() = viewModelScope.launch {
        repository.fetchAllItems()
    }


}