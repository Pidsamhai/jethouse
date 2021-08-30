package com.github.psm.jethouse.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.github.psm.jethouse.db.FakeDataSource
import com.github.psm.jethouse.db.User
import com.github.psm.jethouse.ui.theme.AvatarShape
import com.github.psm.jethouse.ui.theme.JetHouseTheme
import com.github.psm.jethouse.utils.toAvatarUrl

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    user: User
) {
    Box(
        modifier = modifier
            .clip(AvatarShape)
            .background(Color(0xFFEEEEEE))
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberImagePainter(data = user.fullName.toAvatarUrl()),
            contentDescription = "Avatar Image"
        )
    }
}

@Preview
@Composable
private fun ProfileIconPrev() {
    JetHouseTheme {
        ProfileIcon(
            modifier = Modifier.size(60.dp),
            user = FakeDataSource.user
        )
    }
}