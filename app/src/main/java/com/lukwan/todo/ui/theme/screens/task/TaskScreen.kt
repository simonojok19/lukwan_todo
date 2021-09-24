package com.lukwan.todo.ui.theme.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.lukwan.todo.data.models.TodoTask
import com.lukwan.todo.ui.theme.viewmodels.SharedViewModel
import com.lukwan.todo.utils.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (action: Action) -> Unit,
    selectedTask: TodoTask?,
    viewModel: SharedViewModel
) {
    val title by viewModel.title
    val description by viewModel.description
    val priority by viewModel.priority

    Scaffold(topBar = {
        TaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }, content = {
        TaskContent(
            title = title,
            onTitleChange = { viewModel.title.value = it },
            description = description,
            onDescriptionChange = { viewModel.description.value = it },
            priority = priority,
            onPrioritySelected = { viewModel.priority.value = it }
        )
    })
}

