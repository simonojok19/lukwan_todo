package com.lukwan.todo.ui.theme.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.lukwan.todo.utils.Action

@Composable
fun TaskScreen(navigateToListScreen: (action: Action) -> Unit,) {
    Scaffold(topBar = { NewTaskAppBar(navigateToListScreen = {}) }, content = {})
}

