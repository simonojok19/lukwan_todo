package com.lukwan.todo.ui.theme.screens.list

import android.util.Log
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lukwan.todo.R
import com.lukwan.todo.ui.theme.fabBackgroundColor
import com.lukwan.todo.ui.theme.viewmodels.SharedViewModel
import com.lukwan.todo.utils.SearchAppBarState

@Composable
fun ListScreen(
    navigateToTaskScreen: (id: Int) -> Unit,
    viewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true) {
        Log.d("ListScreen", "Launched Effect")
        viewModel.getAllTasks();
    }

    val searchAppBarState: SearchAppBarState by viewModel.searchAppBarState
    val searchTextState: String by viewModel.searchTextState
    val allTasks = viewModel.allTasks.collectAsState()

    Scaffold(
        topBar = {
            ListTopAppBar(
                sharedViewModel = viewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        floatingActionButton = {
            ListFab(onFabClick = navigateToTaskScreen)
        },
        content = { ListContent() }
    )
}

@Composable
fun ListFab(
    onFabClick: (id: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClick(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor,
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button_description),
            tint = Color.White
        )
    }
}