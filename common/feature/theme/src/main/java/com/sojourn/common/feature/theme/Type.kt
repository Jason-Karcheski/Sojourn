package com.sojourn.common.feature.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Font Families
private val fontClashDisplay = FontFamily(
    Font(R.font.clash_display_semibold)
)
private val fontClashGrotesk = FontFamily(
    Font(R.font.clash_grotesk_medium)
)
private val fontGeneralSans = FontFamily(
    Font(R.font.general_sans_regular)
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