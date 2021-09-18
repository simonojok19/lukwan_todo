package com.lukwan.todo.ui.theme.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lukwan.todo.ui.theme.topAppBarBackgroundColor
import com.lukwan.todo.ui.theme.topAppBarContentColor

@Composable
fun ListTopAppBar() {
    DefaultListTopAppBar()
}

@Composable
fun DefaultListTopAppBar(onSearchClick: () -> Unit) {
    TopAppBar(title = {
        Text(text = "Tasks", color = MaterialTheme.colors.topAppBarContentColor)
    }, backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor, actions = {
        ListAppBarActions(onSearchClick = onSearchClick)
    })
}

@Composable
fun ListAppBarActions(onSearchClick: () -> Unit) {
    SearchAction(onSearchClick = onSearchClick)
}

@Composable
fun SearchAction(
    onSearchClick: () -> Unit
) {
    IconButton(onClick = onSearchClick) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search Tasks",
            tint = MaterialTheme.colors.topAppBarContentColor,
        )
    }
}

@Composable
@Preview
fun DefaultListTopAppBarPreview() {
    DefaultListTopAppBar(onSearchClick = {})
}

