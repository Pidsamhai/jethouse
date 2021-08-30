package com.github.psm.jethouse.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.psm.jethouse.R
import com.github.psm.jethouse.ui.theme.AvatarShape
import com.github.psm.jethouse.ui.theme.IconRippleColor
import com.github.psm.jethouse.ui.theme.JetHouseTheme
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues

@Composable
fun HomeTopAppBar(
    searchClick: () -> Unit,
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
                IconButton(onClick = { searchClick() }) {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search",
                        tint = Color.Black
                    )
                }

                Row(
                    modifier = Modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_event_24),
                            contentDescription = "Event",
                            tint = Color.Black
                        )
                    }

                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = "Email",
                            tint = Color.Black
                        )
                    }

                    IconButton(
                        onClick = { },
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notification",
                            tint = Color.Black
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clickable(
                                indication = rememberRipple(
                                    bounded = false,
                                    radius = 24.dp
                                ),
                                interactionSource = remember { MutableInteractionSource() }
                            ) {

                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier
                                .clip(AvatarShape)
                                .background(colorResource(id = R.color.clubhouse_blue_50_a_30))
                                .padding(6.dp),
                            text = "PD",
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTopAppBarPrev() {
    JetHouseTheme {
        HomeTopAppBar(
            searchClick = { }
        )
    }
}