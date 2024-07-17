package com.sojourn.common.feature.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

// Font Families
private val fontClashDisplay = FontFamily(
    Font(R.font.clash_display_semibold)
)
private val fontClashGrotesk = FontFamily(
    Font(R.font.clash_grotesk_medium)
)
private val fontGeneralSans = FontFamily(
    Font(R.font.general_sans_regular, weight = FontWeight.Normal),
    Font(R.font.general_sans_medium, weight = FontWeight.Medium)
)

// Typography
private val BaseTypography = Typography()
internal val SojournTypography = Typography(
    // Display

    // Headline

    // Title
    titleLarge = BaseTypography.titleLarge.copy(
        fontFamily = fontClashDisplay
    ),
    titleMedium = BaseTypography.titleMedium.copy(
        fontFamily = fontClashDisplay
    ),
    titleSmall = BaseTypography.titleSmall.copy(
        fontFamily = fontClashDisplay
    ),

    // Body
    bodyLarge = BaseTypography.bodyLarge.copy(
        fontFamily = fontGeneralSans
    ),
    bodyMedium = BaseTypography.bodyMedium.copy(
        fontFamily = fontGeneralSans
    ),
    bodySmall = BaseTypography.bodySmall.copy(
        fontFamily = fontGeneralSans
    ),

    // Label
    labelLarge = BaseTypography.labelLarge.copy(
        fontFamily = fontClashGrotesk
    ),
    labelMedium = BaseTypography.labelMedium.copy(
        fontFamily = fontClashGrotesk
    ),
    labelSmall = BaseTypography.labelSmall.copy(
        fontFamily = fontClashGrotesk
    ),
)