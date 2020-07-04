package com.jramirez.soccerteamboard.domain

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("strFilename") val name: String,
    @SerializedName("strTime") val time: String
)