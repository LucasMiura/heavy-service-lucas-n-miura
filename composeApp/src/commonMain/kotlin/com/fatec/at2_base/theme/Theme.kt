package com.fatec.at2_base.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val HeavyColors = darkColorScheme(

    primary = Color(0xFFFF9800),

    secondary = Color(0xFF455A64),

    background = Color(0xFF121212),

    surface = Color(0xFF1E1E1E),

    onPrimary = Color.White,

    onBackground = Color.White,

    onSurface = Color.White
)

@Composable
fun HeavyServiceTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(

        colorScheme = HeavyColors,

        content = content
    )
}