package com.lukwan.todo.ui.theme.screens.task

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lukwan.todo.R
import com.lukwan.todo.ui.theme.topAppBarBackgroundColor
import com.lukwan.todo.ui.theme.topAppBarContentColor
import com.lukwan.todo.utils.Action

@Composable
fun TaskAppBar() {
    NewTaskAppBar(navigateToListScreen = {})
}

@Composable
fun NewTaskAppBar(navigateToListScreen: (action: Action) -> Unit) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(text = "Add Task", color = MaterialTheme.colors.topAppBarContentColor)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = { AddAction(onAddClick = navigateToListScreen) }
    )
}

@Composable
fun BackAction(onBackClicked: (action: Action) -> Unit) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.no_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun AddAction(onAddClick: (action: Action) -> Unit) {
    IconButton(onClick = { onAddClick(Action.ADD) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.add_task),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Preview
@Composable
fun NewTaskAppBarPreview() {
    NewTaskAppBar(navigateToListScreen = {})
}