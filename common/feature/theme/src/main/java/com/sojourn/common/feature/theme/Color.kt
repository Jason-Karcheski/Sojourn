package com.sojourn.common.feature.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal val DarkColorScheme = SojournColors(
    material = darkColorScheme(
        primary = Color(0xFF00DF82),
        onPrimary = Color(0xFF191E1A),
        background = Color(0xFF000000),
        onBackground = Color(0xFFFFFFFF)
    ),
    onBackgroundVariant = Color(0xFF606060)
)

internal val LightColorScheme = SojournColors(
    material = lightColorScheme(
        primary = Color(0xFF00DF82),
        onPrimary = Color(0xFF191E1A),
        background = Color(0xFFFFFFFF),
        onBackground = Color(0xFF191E1A),
        surface = Color(0xFFE6F1EC),
        onSurface = Color(0xFF191E1A)
    ),
    onBackgroundVariant = Color(0xFF808080)
)

data class SojournColors(
    val material: ColorScheme,
    val onBackgroundVariant: Color
) {
    val primary: Color get() = material.primary
    val onPrimary: Color get() = material.onPrimary
    val background: Color get() = material.background
    val onBackground: Color get() = material.onBackground
    val surface: Color get() = material.surface
    val onSurface: Color get() = material.onSurface
}