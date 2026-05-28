package com.fatec.at2_base

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.fatec.at2_base.navigation.AppNavigation
import com.fatec.at2_base.theme.AppTheme

@Composable
fun App() {

    val navController = rememberNavController()

    AppTheme {

        AppNavigation(
            navController = navController
        )
    }
}