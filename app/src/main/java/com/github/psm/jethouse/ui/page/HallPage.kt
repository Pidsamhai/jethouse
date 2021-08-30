package com.github.psm.jethouse.ui.page

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.psm.jethouse.R
import com.github.psm.jethouse.db.FakeDataSource
import com.github.psm.jethouse.ui.theme.IconRippleColor
import com.github.psm.jethouse.ui.theme.JetHouseTheme
import com.github.psm.jethouse.ui.widget.RoomCard
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HallPage(
    modifier: Modifier = Modifier,
    friendBtnClick: () -> Unit,
    pagerState: PagerState,
    pageIndex: Int
) {
    var friendBtnAlpha by remember { mutableStateOf(1f) }
    val animFriendBtnAlpha by animateFloatAsState(targetValue = friendBtnAlpha)

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collect {
            if (it != pageIndex) {
                friendBtnAlpha = 0f
            } else {
                friendBtnAlpha = 1f
            }
        }
    }


    CompositionLocalProvider(LocalRippleTheme provides IconRippleColor) {
        Box(
            modifier = modifier.then(Modifier.fillMaxSize())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                repeat(15) {
                    RoomCard(room = FakeDataSource.room)
                }
                Spacer(modifier = Modifier.size(100.dp))
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    MaterialTheme.colors.primary
                                )
                            )
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            modifier = Modifier.alpha(animFriendBtnAlpha),
                            enabled = true,
                            onClick = {
                                friendBtnClick()
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_buddy),
                                tint = Color.Black,
                                contentDescription = "Friend"
                            )
                        }

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable { }
                                .background(colorResource(id = R.color.clubhouse_green))
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 8.dp
                                )
                        ) {
                            Text(
                                text = "+ Start a room",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }

                        IconButton(onClick = { }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_send),
                                tint = Color.Black,
                                contentDescription = null
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
private fun HallPagePrev() {
    JetHouseTheme {
        Scaffold {
            HallPage(
                friendBtnClick = { },
                pagerState = rememberPagerState(pageCount = 1),
                pageIndex = 1
            )
        }
    }
}