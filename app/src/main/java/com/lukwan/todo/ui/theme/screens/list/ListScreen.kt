package com.lukwan.todo.ui.theme.screens.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lukwan.todo.R

@Composable
fun ListScreen(
    navigateToTaskScreen: (id: Int) -> Unit
) {
    Scaffold(
        topBar = { ListTopAppBar() },
        floatingActionButton = {
            ListFab(onFabClick = navigateToTaskScreen)
        }
    ) {}
}

@Composable
@Preview
private fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}

@Composable
fun ListFab(
    onFabClick: (id: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClick(-1)
        }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button_description),
            tint = Color.White
        )
    }
}