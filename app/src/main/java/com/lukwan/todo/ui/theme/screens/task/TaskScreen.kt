package com.lukwan.todo.ui.theme.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun TaskScreen() {
    Scaffold(topBar = {NewTaskAppBar()}, content = {})
}

