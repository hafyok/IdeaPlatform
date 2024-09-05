package com.example.ideaplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ideaplatform.Presentation.MainScreen
import com.example.ideaplatform.ui.theme.IdeaPlatformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            IdeaPlatformTheme {
                MainScreen()
            }
        }
//        GlobalScope.launch {
//            this@MainActivity.let {
//                val item = ItemEntity(id = 0, name = "TEst", time = 151515, tags = "tag1", amount = 1500)
//                ItemRoomDatabase(it).itemDao().insert(item)
//            }
//        }
    }
}
