package com.github.psm.jethouse.db

data class Room(
    val club: Club,
    val name: String,
    val speaker: List<User>,
    val moderator: List<User>,
    val listener: List<User>
) {
    val userCount: Int
        get() = speaker.size + moderator.size
}