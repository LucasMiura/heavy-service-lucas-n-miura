package com.fatec.at2_base.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fatec.at2_base.screen.CadastroOrdemScreen
import com.fatec.at2_base.screen.OrdemServicoScreen
import com.fatec.at2_base.viewmodel.OrdemServicoViewModel

@Composable
fun AppNavigation(
    navController: NavHostController
) {

    val viewModel: OrdemServicoViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {

            OrdemServicoScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable("cadastro") {

            CadastroOrdemScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}