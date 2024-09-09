package com.example.ideaplatform.Presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ideaplatform.Data.ItemDao
import com.example.ideaplatform.Data.ItemEntity
import com.example.ideaplatform.Data.ItemRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application, itemDao: ItemDao) : AndroidViewModel(application) {
    private val repository = ItemRepository(itemDao)
    private val _items = MutableLiveData<List<ItemEntity>>()
    val items: LiveData<List<ItemEntity>> get() = _items

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            repository.fetchAllItems()
            _items.value = repository.allItems
            Log.d("Test vm", _items.value.toString())
        }
    }
}