package com.fatec.at2_base.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fatec.at2_base.viewmodel.OrdemServicoViewModel

fun corStatus(status: String): Color {

    return when (status) {

        "Finalizado" -> Color(0xFF4CAF50)

        "Em análise" -> Color(0xFFFF9800)

        "Aguardando peças" -> Color(0xFFF44336)

        else -> Color.Gray
    }
}

@Composable
fun OrdemServicoScreen(
    navController: NavController,
    viewModel: OrdemServicoViewModel
) {

    val ordens by viewModel.ordens.collectAsState()

    val carregando by viewModel.carregando.collectAsState()

    Scaffold(

        modifier = Modifier.safeDrawingPadding(),

        topBar = {

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),

                shape = RoundedCornerShape(24.dp),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )

            ) {

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),

                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Card(

                        shape = RoundedCornerShape(16.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )

                    ) {

                        Icon(

                            imageVector = Icons.Default.Build,

                            contentDescription = null,

                            tint = Color.White,

                            modifier = Modifier
                                .padding(14.dp)
                                .size(28.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {

                        Text(

                            text = "Heavy Service",

                            style = MaterialTheme.typography.headlineSmall,

                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(

                            text = "Gestão de Ordens de Serviço",

                            style = MaterialTheme.typography.bodyMedium,

                            color = Color.Gray
                        )
                    }
                }
            }
        },

        floatingActionButton = {

            FloatingActionButton(

                onClick = {

                    navController.navigate("cadastro")

                }

            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Adicionar Ordem"
                )
            }
        }

    ) { paddingValues ->

        if (carregando) {

            Column(

                modifier = Modifier.fillMaxSize(),

                verticalArrangement = Arrangement.Center,

                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                CircularProgressIndicator()

                Spacer(modifier = Modifier.height(16.dp))

                Text(

                    text = "Carregando ordens...",

                    textAlign = TextAlign.Center
                )
            }

        } else if (ordens.isEmpty()) {

            Column(

                modifier = Modifier.fillMaxSize(),

                verticalArrangement = Arrangement.Center,

                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(

                    text = "Nenhuma ordem cadastrada",

                    style = MaterialTheme.typography.titleMedium
                )

                Text(

                    text = "Adicione uma nova ordem pelo botão +",

                    color = Color.Gray,

                    modifier = Modifier.padding(top = 8.dp)
                )
            }

        } else {

            LazyVerticalGrid(

                columns = GridCells.Fixed(2),

                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),

                contentPadding = PaddingValues(12.dp),

                horizontalArrangement = Arrangement.spacedBy(12.dp),

                verticalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(ordens) { ordem ->

                    Card(

                        onClick = {

                            navController.navigate(
                                "detalhes/${ordem.id}"
                            )
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .animateContentSize(),

                        shape = RoundedCornerShape(20.dp),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        ),

                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = ordem.cliente,

                                style = MaterialTheme.typography.titleMedium,

                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "${ordem.marca} ${ordem.modelo}",

                                modifier = Modifier.padding(top = 6.dp)
                            )

                            Text(
                                text = "Ano ${ordem.ano}",

                                modifier = Modifier.padding(top = 4.dp)
                            )

                            Text(
                                text = "${ordem.quilometragem} KM",

                                modifier = Modifier.padding(top = 2.dp)
                            )

                            Text(

                                text = ordem.status,

                                color = Color.White,

                                modifier = Modifier
                                    .padding(top = 12.dp)
                                    .background(
                                        corStatus(ordem.status),
                                        RoundedCornerShape(10.dp)
                                    )
                                    .padding(
                                        horizontal = 12.dp,
                                        vertical = 6.dp
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
}