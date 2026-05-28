package com.fatec.at2_base

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.fatec.at2_base.navigation.AppNavigation
import com.fatec.at2_base.theme.HeavyServiceTheme

@Composable
fun App() {

    val navController = rememberNavController()

    HeavyServiceTheme {

        MaterialTheme {

            AppNavigation(navController)

        }
    }
}