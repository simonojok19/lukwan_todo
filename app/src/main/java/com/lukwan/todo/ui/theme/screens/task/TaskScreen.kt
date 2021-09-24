package com.lukwan.todo.ui.theme.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.lukwan.todo.data.models.Priority
import com.lukwan.todo.data.models.TodoTask
import com.lukwan.todo.utils.Action

@Composable
fun TaskScreen(navigateToListScreen: (action: Action) -> Unit, selectedTask: TodoTask?) {

    Scaffold(topBar = {
        TaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }, content = {
        TaskContent(
            title = "Pass Turing Interview",
            onTitleChange = {},
            description = "I need to pass turing interview so that I can get job of my own and take care of my mum",
            onDescriptionChange = {},
            priority = Priority.HIGH,
            onPrioritySelected = {}
        )
    })
}

