package com.github.psm.jethouse.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.psm.jethouse.R
import com.github.psm.jethouse.ui.theme.JetHouseTheme

@Composable
fun FriendPage(
    modifier: Modifier = Modifier
) {

    CompositionLocalProvider(LocalContentColor provides Color.Black) {

        Column(
            modifier = modifier.then(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "\uD83D\uDE34 No one is online right now.")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "You'll see the people you follow who follow you back here whenever they're online")
            Spacer(modifier = Modifier.size(32.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { }
                    .background(colorResource(id = R.color.clubhouse_eggshell_shade))
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
            ) {
                Text(text = "Find people to follow")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FriendPagePrev() {
    JetHouseTheme {
        FriendPage()
    }
}