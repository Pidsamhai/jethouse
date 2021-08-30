package com.github.psm.jethouse.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.github.psm.jethouse.R

private val DarkColorPalette
    @Composable get() = darkColors(
        primary = colorResource(id = R.color.clubhouse_eggshell),
        primaryVariant = colorResource(id = R.color.clubhouse_eggshell_shade),
        secondary = colorResource(id = R.color.clubhouse_blue),
    )

private val LightColorPalette
    @Composable get() = lightColors(
        primary = colorResource(id = R.color.clubhouse_eggshell),
        primaryVariant = colorResource(id = R.color.clubhouse_eggshell_shade),
        secondary = colorResource(id = R.color.clubhouse_blue),

        /* Other default colors to override
        background = Color.White,
        surface = Color.White,
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black,
        */
    )

@Composable
fun JetHouseTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

object IconRippleColor: RippleTheme {

    @Composable
    override fun defaultColor() =
        RippleTheme.defaultRippleColor(
            Color.Black,
            lightTheme = true
        )

    @Composable
    override fun rippleAlpha(): RippleAlpha =
        RippleTheme.defaultRippleAlpha(
            Color.Black,
            lightTheme = true
        )
}