package com.lukwan.todo.ui.theme.screens.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListTopAppBar() {
    DefaultListTopAppBar()
}

@Composable
fun DefaultListTopAppBar() {
    TopAppBar(title = {
        Text(text = "Tasks")
    }, backgroundColor = MaterialTheme.colors.primary)
}

@Composable
@Preview
fun DefaultListTopAppBarPreview() {
    DefaultListTopAppBar()
}