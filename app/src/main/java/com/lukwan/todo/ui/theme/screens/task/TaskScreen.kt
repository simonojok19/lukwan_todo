package com.lukwan.todo.ui.theme.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.lukwan.todo.data.models.TodoTask
import com.lukwan.todo.utils.Action

@Composable
fun TaskScreen(navigateToListScreen: (action: Action) -> Unit, selectedTask: TodoTask?) {

    Scaffold(topBar = {
        TaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }, content = {})
}

