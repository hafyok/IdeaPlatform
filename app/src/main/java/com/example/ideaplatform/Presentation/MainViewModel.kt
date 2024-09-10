package com.example.ideaplatform.Presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ideaplatform.Data.ItemDao
import com.example.ideaplatform.Data.ItemEntity
import com.example.ideaplatform.Data.ItemRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(application: Application, itemDao: ItemDao) : AndroidViewModel(application) {
    private val repository = ItemRepository(itemDao)

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    @OptIn(ExperimentalCoroutinesApi::class)
    val items: LiveData<List<ItemEntity>> = _searchQuery.flatMapLatest { query ->
        repository.allItems.map { list ->
            if (query.isEmpty()) {
                list // Возвращаем весь список, если строка поиска пуста
            } else {
                list.filter { it.name.contains(query, ignoreCase = true) }
            }
        }
    }.asLiveData()

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun removeItem(id: Int) {
        viewModelScope.launch {
            repository.removeItemById(id)
            Log.d("REMOVING", "Removing item with id: $id")
        }
    }
}