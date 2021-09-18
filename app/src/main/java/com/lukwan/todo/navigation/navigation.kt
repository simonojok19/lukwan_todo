package com.lukwan.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.lukwan.todo.navigation.destinations.listComposable
import com.lukwan.todo.navigation.destinations.taskComposable
import com.lukwan.todo.ui.theme.viewmodels.SharedViewModel
import com.lukwan.todo.utils.Constants

@Composable
fun SetupNavigation(
    navController: NavHostController,
    viewModel: SharedViewModel,
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = Constants.LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task,
            viewModel = viewModel
        )

        taskComposable(
            navigateToListScreen = screen.list,
            viewModel = viewModel
        )
    }
}