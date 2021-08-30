package com.github.psm.jethouse.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.psm.jethouse.R
import com.github.psm.jethouse.ui.theme.IconRippleColor
import com.github.psm.jethouse.ui.theme.JetHouseTheme
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues

@Composable
fun ExploreTopAppBar(
    navigateBack: () -> Unit,
) {
    TopAppBar(
        contentPadding = rememberInsetsPaddingValues(
            LocalWindowInsets.current.statusBars
        ),
        elevation = 0.dp
    ) {

        CompositionLocalProvider(LocalRippleTheme provides IconRippleColor) {

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navigateBack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_arrow_back_ios_24),
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }

                Text(
                    text = "Explore".uppercase(),
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )


                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_history_24),
                        contentDescription = "Search",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExploreTopAppBarPrev() {
    JetHouseTheme {
        ExploreTopAppBar(
            navigateBack = { }
        )
    }
}