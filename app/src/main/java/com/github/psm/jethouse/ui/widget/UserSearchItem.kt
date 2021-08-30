package com.github.psm.jethouse.ui.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.psm.jethouse.R
import com.github.psm.jethouse.db.FakeDataSource
import com.github.psm.jethouse.db.User
import com.github.psm.jethouse.ui.theme.JetHouseTheme

@Composable
fun UserSearchItem(
    modifier: Modifier = Modifier,
    user: User
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ProfileIcon(
            user = user,
            modifier = Modifier.size(60.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = user.fullName,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = user.bio,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                fontWeight = FontWeight.Light
            )
        }

        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = colorResource(id = R.color.clubhouse_blue),
                    shape = CircleShape
                )
                .padding(
                    horizontal = 24.dp,
                    vertical = 8.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Follow",
                color = colorResource(id = R.color.clubhouse_blue)
            )
        }
    }
}

@Preview
@Composable
private fun UserSearchItemPrev() {
    JetHouseTheme {
        UserSearchItem(
            modifier = Modifier.fillMaxWidth(),
            user = FakeDataSource.user
        )
    }
}