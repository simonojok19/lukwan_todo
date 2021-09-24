package com.lukwan.todo.ui.theme.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current

    Scaffold(topBar = {
        TaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = {
                if (it == Action.NO_ACTION) {
                    navigateToListScreen(it)
                } else {
                    if (viewModel.validateFields()) {
                        navigateToListScreen(it)
                    } else {
                        displayToast(context)
                    }
                }
            }
        )
    }, content = {
        TaskContent(
            title = title,
            onTitleChange = { viewModel.updateTitle(it) },
            description = description,
            onDescriptionChange = { viewModel.description.value = it },
            priority = priority,
            onPrioritySelected = { viewModel.priority.value = it }
        )
    })
}

fun displayToast(context: Context) {
    Toast.makeText(context, "Fields Empty", Toast.LENGTH_LONG).show()
}

