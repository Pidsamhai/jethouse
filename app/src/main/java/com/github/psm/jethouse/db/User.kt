package com.github.psm.jethouse.db

data class User(
    val name: String,
    val lastName: String,
    val bio: String
) {
    val fullName: String
        get() = "$name $lastName"
}
