package com.jramirez.soccerteamboard.service.repository

import com.jramirez.soccerteamboard.service.response.GetTeamsResponse

class TeamRepositoryImp : BaseRepository(), TeamRepository {
    override suspend fun getTeams(leagueId: String): GetTeamsResponse = client.getTeams(leagueId)
}