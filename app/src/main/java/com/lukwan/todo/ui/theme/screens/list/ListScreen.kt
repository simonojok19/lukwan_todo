package com.lukwan.todo.ui.theme.screens.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lukwan.todo.R
import com.lukwan.todo.ui.theme.fabBackgroundColor
import com.lukwan.todo.ui.theme.viewmodels.SharedViewModel

@Composable
fun ListScreen(
    navigateToTaskScreen: (id: Int) -> Unit,
    viewModel: SharedViewModel
) {
    Scaffold(
        topBar = { ListTopAppBar(onSearchClick = {}, onSortClick = {}, onDeleteClick = {}) },
        floatingActionButton = {
            ListFab(onFabClick = navigateToTaskScreen)
        }
    ) {}
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