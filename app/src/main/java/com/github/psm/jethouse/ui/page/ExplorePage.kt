package com.github.psm.jethouse.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.psm.jethouse.R
import com.github.psm.jethouse.db.FakeDataSource
import com.github.psm.jethouse.ui.theme.JetHouseTheme
import com.github.psm.jethouse.ui.widget.ExploreTopAppBar
import com.github.psm.jethouse.ui.widget.SearchTextField
import com.github.psm.jethouse.ui.widget.UserSearchItem

@Composable
fun ExplorePage(
    navigateBack: () -> Unit = { }
) {
    var searchKeyword by rememberSaveable { mutableStateOf("") }

    CompositionLocalProvider(LocalContentColor provides Color.Black) {
        Scaffold(
            backgroundColor = MaterialTheme.colors.primary,
            topBar = {
                ExploreTopAppBar(
                    navigateBack = navigateBack
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
                    .padding(horizontal = 16.dp)
            ) {
                SearchTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 8.dp
                        ),
                    value = searchKeyword,
                    onValueChange = { searchKeyword = it },
                    placeholder = "Find People and Clubs"
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = "People To Follow".uppercase(),
                        color = colorResource(id = R.color.clubhouse_eggshell_dark).copy(alpha = 0.8f),
                        fontWeight = FontWeight.Medium
                    )

                    FakeDataSource.users.forEachIndexed { index, item ->
                        UserSearchItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    bottom = if (index == FakeDataSource.users.size - 1)
                                        8.dp else 0.dp
                                ),
                            user = item
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ExplorePagePrev() {
    JetHouseTheme {
        ExplorePage()
    }
}