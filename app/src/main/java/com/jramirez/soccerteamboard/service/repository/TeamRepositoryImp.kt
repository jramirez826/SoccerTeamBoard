package com.jramirez.soccerteamboard.service.repository

import com.jramirez.soccerteamboard.service.ResultServiceHandler
import com.jramirez.soccerteamboard.service.response.GetTeamsResponse

class TeamRepositoryImp :
    BaseRepository(), TeamRepository {
    override suspend fun getTeams(leagueId: String): ResultServiceHandler<GetTeamsResponse> {
        return handleAPICall { client.getTeams(leagueId) }
    }
}