package com.sojourn.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.sojourn.common.feature.composable.SojournTopBar
import com.sojourn.common.feature.composable.sojournListSection
import com.sojourn.common.feature.extension.spacedByMedium
import com.sojourn.common.feature.theme.SojournTheme
import com.sojourn.common.feature.theme.sojournColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val listState = rememberLazyListState()

            SojournTheme {
                Surface(color = MaterialTheme.sojournColors.background) {
                    Scaffold(
                        modifier = Modifier.systemBarsPadding(),
                        topBar = {
                            SojournTopBar(
                                title = "Example Screen",
                                subtitle = "Something To Demo",
                                isCollapsed = listState.canScrollBackward,
                                onBackPressed = {}
                            )
                        }
                    ) { innerPadding ->
                        LazyColumn(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                            contentPadding = PaddingValues(horizontal = dimensionResource(com.sojourn.common.feature.theme.R.dimen.padding_medium)),
                            state = listState,
                            verticalArrangement = Arrangement.spacedByMedium()
                        ) {
                            sojournListSection(
                                header = "Example List Section",
                                items = listOf(
                                    "Item One",
                                    "Item Two",
                                    "Item Three"
                                ),
                                onItemClicked = {}
                            )
                        }
                    }
                }
            }
        }
    }
}