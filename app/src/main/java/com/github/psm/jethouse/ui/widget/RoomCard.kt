package com.github.psm.jethouse.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.psm.jethouse.R
import com.github.psm.jethouse.db.FakeDataSource
import com.github.psm.jethouse.db.Room
import com.github.psm.jethouse.ui.theme.JetHouseTheme

@Composable
fun RoomCard(
    modifier: Modifier = Modifier,
    room: Room,
    profileSize: Dp = 45.dp
) {
    val profileOverlapsOffset = profileSize / 4
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = room.club.name.uppercase()
                )

                Spacer(modifier = Modifier.width(16.dp))

                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = "Club",
                    tint = colorResource(id = R.color.clubhouse_green),
                    modifier = Modifier.size(16.dp)
                )
            }

            Text(
                text = room.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.size(16.dp))

            Row {
                BoxWithConstraints(
                    modifier = Modifier
                        .weight(0.6f)
                        .height(profileSize + (profileSize / 2)),
                    contentAlignment = Alignment.Center
                ) {

                    ProfileIcon(
                        modifier = Modifier
                            .size(profileSize)
                            .offset(profileOverlapsOffset, profileOverlapsOffset),
                        user = room.moderator[0]
                    )

                    ProfileIcon(
                        modifier = Modifier
                            .size(profileSize)
                            .offset(-(profileOverlapsOffset), -(profileOverlapsOffset)),
                        user = room.moderator[1]
                    )
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    room.moderator.take(3).forEach { moderator ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = moderator.fullName)
                            Spacer(modifier = Modifier.size(8.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_round_message_24),
                                contentDescription = "Message",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun RoomCardPrev() {
    JetHouseTheme {
        RoomCard(
            modifier = Modifier
                .fillMaxWidth(),
            room = FakeDataSource.room
        )
    }
}