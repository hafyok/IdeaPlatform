package com.example.ideaplatform.Presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ideaplatform.R


@Composable
fun DeleteDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_warning_24),
                    contentDescription = null
                )
                Text(text = "Удаление товара", fontSize = 18.sp)
                Text(
                    text = "Вы действительно хотите удалить выбранный товар?",
                    textAlign = TextAlign.Center
                )
                Row(
                    horizontalArrangement = Arrangement.End, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    ClickableText(text = AnnotatedString("Нет"),
                        onClick = {
                            onDismiss()
                        })
                    Spacer(modifier = Modifier.padding(horizontal = 16.dp))
                    ClickableText(text = AnnotatedString("Да"),
                        modifier = Modifier.padding(end = 16.dp),
                        onClick = {
                            onConfirm()
                        })
                }
            }
        }
    }

}