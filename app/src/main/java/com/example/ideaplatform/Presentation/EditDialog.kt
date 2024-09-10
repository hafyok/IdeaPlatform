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
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ideaplatform.R

@Composable
fun EditDialog(onDismissRequest: () -> Unit, amount: Int) {
    Dialog(
        onDismissRequest = { onDismissRequest() }
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
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "-", fontSize = 32.sp)
                    Text(text = amount.toString(), fontSize = 24.sp)
                    Text(text = "+", fontSize = 28.sp)
                }
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Text(text = "Отмена")
                    Spacer(modifier = Modifier.padding(horizontal = 16.dp))
                    Text(text = "Принять", modifier = Modifier.padding(end = 16.dp))
                }
            }
        }

    }
}

@Composable
@Preview
fun PreviewEditDialog(){
    EditDialog(onDismissRequest = { /*TODO*/ }, amount = 30)
}