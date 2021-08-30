package com.github.psm.jethouse.ui.page

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.github.psm.jethouse.ui.theme.JetHouseTheme
import com.github.psm.jethouse.ui.widget.HomeTopAppBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePage(
    navigateToExplorePage: () -> Unit = { }
) {
    val coroutineScope = rememberCoroutineScope()
    val pageState = rememberPagerState(
        pageCount = 2,
        initialPage = 1
    )

    val navigateToFriendPage: () -> Unit = {
        coroutineScope.launch {
            pageState.animateScrollToPage(0)
        }
    }

    Scaffold(
        topBar = {
            HomeTopAppBar(
                searchClick = { navigateToExplorePage() }
            )
        },
        backgroundColor = MaterialTheme.colors.primarySurface
    ) {
        HorizontalPager(state = pageState) { page ->
            when (page) {
                0 -> FriendPage(
                    modifier = Modifier.padding(
                        end = 48.dp
                    )
                )
                1 -> HallPage(
                    modifier = Modifier
                        .offset {
                            val pageOffset = calculateCurrentOffsetForPage(page)
                            IntOffset(
                                x = (48.dp * pageOffset).roundToPx(),
                                y = 0
                            )
                        }
                        .graphicsLayer {
                            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        },
                    friendBtnClick = { navigateToFriendPage() },
                    pagerState = pageState,
                    pageIndex = 1
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomePagePrev() {
    JetHouseTheme {
        HomePage()
    }
}