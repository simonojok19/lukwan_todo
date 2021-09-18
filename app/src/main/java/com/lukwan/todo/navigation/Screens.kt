package com.lukwan.todo.navigation

import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavController
import com.lukwan.todo.utils.Action
import com.lukwan.todo.utils.Constants

class Screens(navController: NavController) {
    val list: (action: Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(Constants.LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (id: Int) -> Unit = {id ->
        navController.navigate("task/${id}")
    }
}