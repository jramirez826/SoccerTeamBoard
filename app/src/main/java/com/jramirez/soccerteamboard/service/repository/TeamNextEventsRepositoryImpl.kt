package com.jramirez.soccerteamboard.service.repository

import com.jramirez.soccerteamboard.service.ResultServiceHandler
import com.jramirez.soccerteamboard.service.response.GetTeamNextEventsResponse

class TeamNextEventsRepositoryImpl :
    BaseRepository(), TeamNextEventRepository {
    override suspend fun getTeamNextEvents(teamId: String): ResultServiceHandler<GetTeamNextEventsResponse> =
        handleAPICall { client.getTeamNextEvents(teamId) }
}