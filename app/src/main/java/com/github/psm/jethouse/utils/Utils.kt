package com.github.psm.jethouse.utils

fun String.toAvatarUrl(): String = AVATAR_UR_TEMPLATE.format(this)