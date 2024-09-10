package com.example.ideaplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.ideaplatform.Data.ItemRoomDatabase
import com.example.ideaplatform.Presentation.MainScreen
import com.example.ideaplatform.Presentation.MainViewModel
import com.example.ideaplatform.Presentation.MainViewModelFactory
import com.example.ideaplatform.ui.theme.IdeaPlatformTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = ItemRoomDatabase(this, CoroutineScope(Dispatchers.IO))
        val itemDao = database.itemDao()

        val viewModelFactory = MainViewModelFactory(application, itemDao)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        enableEdgeToEdge()

        setContent {
            IdeaPlatformTheme {
                MainScreen(viewModel)
            }
        }
    }
}
