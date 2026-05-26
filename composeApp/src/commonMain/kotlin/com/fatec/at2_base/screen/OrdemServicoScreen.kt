package com.fatec.at2_base.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fatec.at2_base.viewmodel.OrdemServicoViewModel

@Composable
fun OrdemServicoScreen() {

    val viewModel = OrdemServicoViewModel()

    val ordens by viewModel.ordens.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Heavy Service - Lucas Miura",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        LazyColumn {

            items(ordens) { ordem ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text("OS #${ordem.id}")

                        Text("Cliente: ${ordem.cliente}")

                        Text("${ordem.marca} ${ordem.modelo}")

                        Text("${ordem.quilometragem} km")

                        Text("Status: ${ordem.status}")

                    }

                }
            }
        }
    }
}