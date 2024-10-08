package com.example.ideaplatform.Presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ideaplatform.Data.ItemEntity
import com.example.ideaplatform.Data.ItemRepository
import com.example.ideaplatform.Data.ItemRoomDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val itemDb: ItemRoomDatabase
): ViewModel() {
    private val repository = ItemRepository(itemDb.dao)

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

    fun updateItem(id: Int, newAmount: Int) {
        viewModelScope.launch {
            repository.updateAmount(id, newAmount)
            Log.d("UPDATING", "Updated item id: $id with new amount: $newAmount")
        }
    }
}