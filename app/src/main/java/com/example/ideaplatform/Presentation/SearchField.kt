package com.example.ideaplatform.Presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SearchField() {
    val message = remember {
        mutableStateOf(TextFieldValue(""))
    }
    OutlinedTextField(
        value = message.value,
        label = { Text(text = "Поиск товаров")},
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        onValueChange = { message.value = it },
        textStyle = TextStyle(fontSize = 15.sp, color = Color.Gray),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black, // цвет при получении фокуса
            unfocusedBorderColor = Color.Gray  // цвет при отсутствии фокуса
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    )
}