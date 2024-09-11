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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ideaplatform.R

@Composable
fun EditDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    amount: Int,
    onAmountChange: (Int) -> Unit
) {
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    contentDescription = null
                )

                Text(text = "Количество товара", fontSize = 18.sp)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ClickableText(text = AnnotatedString("-"), style = TextStyle(fontSize = 32.sp), onClick = {
                        onAmountChange(amount - 1)
                    })
                    Text(text = amount.toString(), fontSize = 24.sp)
                    ClickableText(text = AnnotatedString("+"), style = TextStyle(fontSize = 28.sp), onClick = {
                        onAmountChange(amount + 1)
                    })
                }
                Row(
                    horizontalArrangement = Arrangement.End, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    ClickableText(text = AnnotatedString("Отмена"),
                        onClick = {
                            onDismiss()
                        })
                    Spacer(modifier = Modifier.padding(horizontal = 16.dp))
                    ClickableText(text = AnnotatedString("Принять"),
                        modifier = Modifier.padding(end = 16.dp),
                        onClick = {
                            onConfirm()
                        })
                }
            }
        }

    }
}

/*
@Composable
@Preview
fun PreviewEditDialog() {
    EditDialog(onDismissRequest = { */
/*TODO*//*
 }, amount = 30)
}*/
