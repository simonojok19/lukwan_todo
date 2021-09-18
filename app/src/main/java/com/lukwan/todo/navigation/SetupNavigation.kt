package com.lukwan.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.lukwan.todo.navigation.destinations.listComposable
import com.lukwan.todo.navigation.destinations.taskComposable
import com.lukwan.todo.utils.Constants

@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = Constants.LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task
        )

        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}