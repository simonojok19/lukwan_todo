package com.lukwan.todo.navigation.destinations

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.lukwan.todo.ui.theme.screens.list.ListScreen
import com.lukwan.todo.ui.theme.viewmodels.SharedViewModel
import com.lukwan.todo.utils.Constants

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (id: Int) -> Unit,
    viewModel: SharedViewModel,
) {
    composable(
        route = Constants.LIST_SCREEN,
        arguments = listOf(navArgument(Constants.LIST_ARGUMENT_KEY) {
            type = NavType.StringArrayType
        })
    ) {
        ListScreen(navigateToTaskScreen = navigateToTaskScreen, viewModel = viewModel)
    }
}