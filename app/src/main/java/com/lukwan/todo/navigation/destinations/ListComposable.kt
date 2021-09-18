package com.lukwan.todo.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.lukwan.todo.ui.theme.screens.list.ListScreen
import com.lukwan.todo.utils.Constants

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (id: Int) -> Unit,
) {
    composable(
        route = Constants.LIST_SCREEN,
        arguments = listOf(navArgument(Constants.LIST_ARGUMENT_KEY) {
            type = NavType.StringArrayType
        })
    ) {
        ListScreen(navigateToTaskScreen = navigateToTaskScreen)
    }
}