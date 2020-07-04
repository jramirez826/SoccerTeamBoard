package com.jramirez.soccerteamboard.domain

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("idTeam") val id: String,
    @SerializedName("strTeam") val name: String,
    @SerializedName("strStadium") val stadium: String,
    @SerializedName("strDescriptionEN") val description: String,
    @SerializedName("intFormedYear") val foundation: String,
    @SerializedName("strTeamBadge") val badge: String,
    @SerializedName("strTeamJersey") val jersey: String,
    @SerializedName("strWebsite") val website: String,
    @SerializedName("strFacebook") val facebook: String,
    @SerializedName("strTwitter") val twitter: String,
    @SerializedName("strInstagram") val instagram: String,
    @SerializedName("strYoutube") val youtube: String
)