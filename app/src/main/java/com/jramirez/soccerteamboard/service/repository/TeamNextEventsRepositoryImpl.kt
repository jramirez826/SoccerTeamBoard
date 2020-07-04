package com.jramirez.soccerteamboard.service.repository

class TeamNextEventsRepositoryImpl : BaseRepository(), TeamNextEventRepository {
    override suspend fun getTeamNextEvents(teamId: String) = client.getTeamNextEvents(teamId)
}