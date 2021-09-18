package com.lukwan.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lukwan.todo.navigation.SetupNavigation
import com.lukwan.todo.ui.theme.TodoTheme
import com.lukwan.todo.ui.theme.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels<SharedViewModel>()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                navHostController = rememberNavController();
                SetupNavigation(navController = navHostController, viewModel = sharedViewModel)
            }
        }
    }
}
