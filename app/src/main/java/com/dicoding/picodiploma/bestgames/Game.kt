package com.dicoding.picodiploma.bestgames

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val name: String,
    val description: String,
    val rating: String,
    val photo: Int,
    val profile: Int,
    val creator: String

) : Parcelable
