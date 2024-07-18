package com.sojourn.common.feature.annotation

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Provides a collection of previews for a Composable.
 */
@Preview(
    group = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    group = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class ComponentPreview()
