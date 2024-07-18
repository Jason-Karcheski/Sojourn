package com.sojourn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sojourn.common.feature.composable.SojournTextField
import com.sojourn.common.feature.composable.SojournTopBar
import com.sojourn.common.feature.theme.SojournTheme
import com.sojourn.common.feature.theme.sojournColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var textFieldContent by remember { mutableStateOf("") }

            SojournTheme {
                Surface(color = MaterialTheme.sojournColors.background) {
                    Column(modifier = Modifier.systemBarsPadding().fillMaxSize()) {
                        SojournTopBar(
                            title = "A Title Doodad",
                            subtitle = "A Subtitle",
                            onBackPressed = {},
                            isCollapsed = false
                        )

                        SojournTextField(
                            value = textFieldContent,
                            onValueChanged = { new -> textFieldContent = new },
                            placeholder = "Example Placeholder"
                        )
                    }
                }
            }
        }
    }
}