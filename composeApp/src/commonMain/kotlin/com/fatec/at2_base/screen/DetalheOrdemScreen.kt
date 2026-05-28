package com.fatec.at2_base.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fatec.at2_base.model.OrdemServico
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalheOrdemScreen(
    navController: NavController,
    ordem: OrdemServico
) {

    Scaffold(

        modifier = Modifier.safeDrawingPadding(),

        topBar = {

            TopAppBar(

                title = {

                    Text("Detalhes da Ordem")

                },

                navigationIcon = {

                    IconButton(

                        onClick = {

                            navController.popBackStack()

                        }

                    ) {

                        Icon(

                            imageVector = Icons.Default.ArrowBack,

                            contentDescription = "Voltar"

                        )
                    }
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

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            Card(

                shape = RoundedCornerShape(20.dp),

                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )

            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = ordem.cliente,

                        style = MaterialTheme.typography.headlineSmall,

                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "${ordem.marca} ${ordem.modelo}",

                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Text(
                        text = "Ano: ${ordem.ano}",

                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Text(
                        text = "Quilometragem: ${ordem.quilometragem} KM",

                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Text(

                        text = ordem.status,

                        color = Color.White,

                        modifier = Modifier
                            .padding(top = 16.dp)
                            .background(
                                corStatus(ordem.status),
                                RoundedCornerShape(10.dp)
                            )
                            .padding(
                                horizontal = 14.dp,
                                vertical = 8.dp
                            )
                    )
                }
            }

            Card(

                shape = RoundedCornerShape(20.dp),

                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )

            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Solicitação",

                        style = MaterialTheme.typography.titleLarge,

                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = ordem.solicitacao,

                        modifier = Modifier.padding(top = 12.dp)
                    )
                }
            }

            Card(

                shape = RoundedCornerShape(20.dp),

                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )

            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Data de abertura",

                        style = MaterialTheme.typography.titleMedium,

                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = ordem.dataAbertura,

                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}