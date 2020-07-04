package com.jramirez.soccerteamboard.service.repository

import com.jramirez.soccerteamboard.service.RetrofitClient
import com.jramirez.soccerteamboard.service.TeamsAPI
import com.jramirez.soccerteamboard.service.response.GetTeamsResponse

class TeamRepositoryImp : TeamRepository {

    private val client: TeamsAPI = RetrofitClient.client

    override suspend fun getTeams(leagueId: String): GetTeamsResponse = client.getTeams(leagueId)
}