package com.github.psm.jethouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.core.view.WindowCompat
import com.github.psm.jethouse.navigation.NavGraph
import com.github.psm.jethouse.ui.theme.JetHouseTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            JetHouseTheme {
                val systemUiController = rememberSystemUiController()
                val bgColor = MaterialTheme.colors.primary
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = bgColor,
                        darkIcons = true
                    )
                }
                ProvideWindowInsets {
                    NavGraph()
                }
            }
        }
    }
}