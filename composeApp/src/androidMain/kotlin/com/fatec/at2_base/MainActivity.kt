package com.fatec.at2_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fatec.at2_base.screen.OrdemServicoScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            MaterialTheme {

                OrdemServicoScreen()

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppAndroidPreview() {

    MaterialTheme {

        OrdemServicoScreen()

    }
}