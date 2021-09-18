package com.lukwan.todo.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.lukwan.todo.utils.Action
import com.lukwan.todo.utils.Constants

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (action: Action) -> Unit
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(
            navArgument(Constants.TASK_ARGUMENT_KEY) {
                type = NavType.IntType
            },
        )
    ) {}
}