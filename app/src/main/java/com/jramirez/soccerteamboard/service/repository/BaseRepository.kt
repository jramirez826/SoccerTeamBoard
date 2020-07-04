package com.jramirez.soccerteamboard.service.repository

import com.jramirez.soccerteamboard.service.RetrofitClient
import com.jramirez.soccerteamboard.service.TeamsAPI

open class BaseRepository {
    val client: TeamsAPI = RetrofitClient.client
}