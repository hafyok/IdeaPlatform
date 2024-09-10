package com.example.ideaplatform.Presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ideaplatform.Data.ItemDao
import com.example.ideaplatform.Data.ItemEntity
import com.example.ideaplatform.Data.ItemRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application, itemDao: ItemDao) : AndroidViewModel(application) {
    private val repository = ItemRepository(itemDao)
    val items: LiveData<List<ItemEntity>> get() = repository.allItems.asLiveData()

    fun removeItem(id: Int){
        viewModelScope.launch {
            repository.removeItemById(id)
            Log.d("REMOVING", "Removing item with id: $id")
        }
    }
}