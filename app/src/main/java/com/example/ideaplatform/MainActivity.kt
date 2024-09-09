package com.example.ideaplatform

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ideaplatform.Data.ItemRoomDatabase
import com.example.ideaplatform.Data.mockData
import com.example.ideaplatform.ui.theme.IdeaPlatformTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            IdeaPlatformTheme {


            }
        }
        val database =
            ItemRoomDatabase(context = this@MainActivity, CoroutineScope(Dispatchers.IO))
        GlobalScope.launch {
            Log.d("DB test", database.itemDao().getItems().toString())
        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IdeaPlatformTheme {
        Greeting("Android")
    }
}