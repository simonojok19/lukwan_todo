package com.lukwan.todo.ui.theme.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lukwan.todo.R
import com.lukwan.todo.data.models.Priority
import com.lukwan.todo.ui.theme.topAppBarBackgroundColor
import com.lukwan.todo.ui.theme.topAppBarContentColor

@Composable
fun ListTopAppBar(onSearchClick: () -> Unit) {
    DefaultListTopAppBar(onSearchClick = onSearchClick)
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
            contentDescription = stringResource(id = R.string.search_button_description),
            tint = MaterialTheme.colors.topAppBarContentColor,
        )
    }
}

@Composable
fun SortAction(
    onSortClick: (priority: Priority) -> Unit
) {

}

@Composable
@Preview
fun DefaultListTopAppBarPreview() {
    DefaultListTopAppBar(onSearchClick = {})
}

