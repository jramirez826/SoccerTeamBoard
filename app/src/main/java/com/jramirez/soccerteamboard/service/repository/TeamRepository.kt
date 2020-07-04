package com.jramirez.soccerteamboard.service.repository

import com.jramirez.soccerteamboard.service.ResultServiceHandler
import com.jramirez.soccerteamboard.service.response.GetTeamsResponse

interface TeamRepository {
    suspend fun getTeams(leagueId: String): ResultServiceHandler<GetTeamsResponse>
}