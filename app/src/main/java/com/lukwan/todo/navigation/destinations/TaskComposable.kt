package com.lukwan.todo.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.lukwan.todo.ui.theme.screens.task.TaskScreen
import com.lukwan.todo.ui.theme.viewmodels.SharedViewModel
import com.lukwan.todo.utils.Action
import com.lukwan.todo.utils.Constants

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (action: Action) -> Unit,
    viewModel: SharedViewModel
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(
            navArgument(Constants.TASK_ARGUMENT_KEY) {
                type = NavType.IntType
            },
        )
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(Constants.TASK_ARGUMENT_KEY)
        viewModel.getSelectedTask(taskId = taskId)
        val selectedTask by viewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = selectedTask) {
            viewModel.updateTaskFields(selectedTask)
        }

        TaskScreen(navigateToListScreen, selectedTask, viewModel)
    }
}