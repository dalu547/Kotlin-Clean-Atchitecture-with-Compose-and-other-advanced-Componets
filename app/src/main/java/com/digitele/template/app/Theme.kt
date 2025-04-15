package com.digitele.template.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = PrimaryGreen,
    onPrimary = White,
    background = White,
    onBackground = TextColor,
    surface = White,
    onSurface = TextColor
)

@Composable
fun TemplateTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = AppTypography,
        content = content
    )
}
