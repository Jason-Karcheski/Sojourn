package com.sojourn.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.sojourn.common.theme.SojournTheme
import com.sojourn.common.theme.sojournColors
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SojournTheme {
                Surface(color = MaterialTheme.sojournColors.background) {
                    SojournNavGraph()
                }
            }
        }
    }
}