package com.example.ideaplatform.Presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ideaplatform.R

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val itemsTov by viewModel.items.observeAsState(emptyList())
    val searchQuery by viewModel.searchQuery.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = Color.Black,
                    navigationIconContentColor = Color.Black,
                    scrolledContainerColor = Color.Black
                ),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.list_items),
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            SearchField(
                searchQuery = searchQuery,
                onSearchQueryChanged = { query -> viewModel.updateSearchQuery(query) }
            )
            LazyColumn {
                items(itemsTov.size) { item ->
                    ItemCatalog(
                        title = itemsTov[item].name,
                        tags = itemsTov[item].tags,
                        quantity = itemsTov[item].amount,
                        dateAdded = itemsTov[item].time,
                        onEditClick = { /*TODO*/ },
                        onDeleteClick = { viewModel.removeItem(itemsTov[item].id) })
                }
            }
        }
    }
}