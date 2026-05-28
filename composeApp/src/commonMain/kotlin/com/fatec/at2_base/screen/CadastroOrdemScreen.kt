package com.fatec.at2_base.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fatec.at2_base.model.OrdemServico
import com.fatec.at2_base.viewmodel.OrdemServicoViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroOrdemScreen(
    navController: NavController,
    viewModel: OrdemServicoViewModel
) {

    val ordens by viewModel.ordens.collectAsState()

    val snackbarHostState =
        remember { SnackbarHostState() }

    val scope = rememberCoroutineScope()

    var cliente by remember { mutableStateOf("") }

    var marca by remember { mutableStateOf("") }

    var modelo by remember { mutableStateOf("") }

    var ano by remember { mutableStateOf("") }

    var quilometragem by remember { mutableStateOf("") }

    var solicitacao by remember { mutableStateOf("") }

    var status by remember { mutableStateOf("Em análise") }

    Scaffold(

        modifier = Modifier.safeDrawingPadding(),

        snackbarHost = {

            SnackbarHost(
                hostState = snackbarHostState
            )
        },

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
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {

            Card(

                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )

            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Dados do Caminhão",

                        style = MaterialTheme.typography.titleMedium,

                        modifier = Modifier.padding(bottom = 16.dp)
                    )

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

                    OutlinedTextField(

                        value = ano,

                        onValueChange = {
                            ano = it
                        },

                        label = {
                            Text("Ano")
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                    )

                    OutlinedTextField(

                        value = quilometragem,

                        onValueChange = {
                            quilometragem = it
                        },

                        label = {
                            Text("Quilometragem")
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                    )
                }
            }

            Card(

                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )

            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Solicitação",

                        style = MaterialTheme.typography.titleMedium,

                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    OutlinedTextField(

                        value = solicitacao,

                        onValueChange = {
                            solicitacao = it
                        },

                        label = {
                            Text("Descreva o problema")
                        },

                        modifier = Modifier.fillMaxWidth(),

                        minLines = 4
                    )

                    OutlinedTextField(

                        value = status,

                        onValueChange = {
                            status = it
                        },

                        label = {
                            Text("Status")
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                    )
                }
            }

            Button(

                onClick = {

                    viewModel.adicionarOrdem(

                        OrdemServico(

                            id = ordens.size + 1,

                            cliente = cliente,

                            marca = marca,

                            modelo = modelo,

                            ano = ano.toIntOrNull() ?: 0,

                            quilometragem = quilometragem.toIntOrNull() ?: 0,

                            solicitacao = solicitacao,

                            status = status,

                            dataAbertura = "2026-05-27"
                        )
                    )

                    scope.launch {

                        snackbarHostState.showSnackbar(
                            "Ordem cadastrada com sucesso!"
                        )

                        navController.popBackStack()
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)

            ) {

                Text("Salvar Ordem")

            }
        }
    }
}