package com.jramirez.soccerteamboard.service.repository

import com.jramirez.soccerteamboard.service.response.GetTeamsResponse

interface TeamRepository {

    suspend fun getTeams(leagueId: String): GetTeamsResponse
}