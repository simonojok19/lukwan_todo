package com.lukwan.todo.ui.theme.screens.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lukwan.todo.ui.theme.topAppBarBackgroundColor
import com.lukwan.todo.ui.theme.topAppBarContentColor

@Composable
fun ListTopAppBar() {
    DefaultListTopAppBar()
}

@Composable
fun DefaultListTopAppBar() {
    TopAppBar(title = {
        Text(text = "Tasks", color = MaterialTheme.colors.topAppBarContentColor)
    }, backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor)
}

@Composable
@Preview
fun DefaultListTopAppBarPreview() {
    DefaultListTopAppBar()
}