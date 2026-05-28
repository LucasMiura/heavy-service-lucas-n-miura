package com.fatec.at2_base.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fatec.at2_base.model.OrdemServico
import com.fatec.at2_base.viewmodel.OrdemServicoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroOrdemScreen(
    navController: NavController,
    viewModel: OrdemServicoViewModel
) {

    val ordens by viewModel.ordens.collectAsState()

    var cliente by remember {
        mutableStateOf("")
    }

    var marca by remember {
        mutableStateOf("")
    }

    var modelo by remember {
        mutableStateOf("")
    }

    Scaffold(

        modifier = Modifier.safeDrawingPadding(),

        topBar = {

            TopAppBar(

                title = {

                    Text("Nova Ordem de Serviço")

                }
            )
        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)

        ) {

            OutlinedTextField(

                value = cliente,

                onValueChange = {
                    cliente = it
                },

                label = {
                    Text("Cliente")
                },

                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(

                value = marca,

                onValueChange = {
                    marca = it
                },

                label = {
                    Text("Marca")
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            OutlinedTextField(

                value = modelo,

                onValueChange = {
                    modelo = it
                },

                label = {
                    Text("Modelo")
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            Button(

                onClick = {

                    viewModel.adicionarOrdem(

                        OrdemServico(

                            id = ordens.size + 1,

                            cliente = cliente,

                            marca = marca,

                            modelo = modelo,

                            ano = 2024,

                            quilometragem = 0,

                            solicitacao = "Nova solicitação",

                            status = "Em análise",

                            dataAbertura = "2026-05-27"
                        )
                    )

                    navController.popBackStack()

                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)

            ) {

                Text("Salvar Ordem")

            }
        }
    }
}