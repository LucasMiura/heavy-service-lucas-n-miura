package com.fatec.at2_base.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fatec.at2_base.viewmodel.OrdemServicoViewModel

@Composable
fun OrdemServicoScreen() {

    val viewModel: OrdemServicoViewModel = viewModel()

    val ordens by viewModel.ordens.collectAsState()

    if (ordens.isEmpty()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(16.dp)
        ) {
            Text("Carregando ordens...")
        }

    } else {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
        ) {

            items(ordens) { ordem ->

                Card(
                    modifier = Modifier.padding(8.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = ordem.cliente,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text("${ordem.marca} ${ordem.modelo}")
                        Text("Ano: ${ordem.ano}")
                        Text("KM: ${ordem.quilometragem}")
                        Text("Status: ${ordem.status}")
                    }
                }
            }
        }
    }
}