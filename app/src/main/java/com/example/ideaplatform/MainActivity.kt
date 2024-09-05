package com.example.ideaplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ideaplatform.Data.ItemEntity
import com.example.ideaplatform.Data.ItemRoomDatabase
import com.example.ideaplatform.ui.theme.IdeaPlatformTheme
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
        GlobalScope.launch {
            this@MainActivity.let {
                val item = ItemEntity(id = 0, name = "TEst", time = 151515, tags = "tag1", amount = 1500)
                ItemRoomDatabase(it).itemDao().insert(item)
            }
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