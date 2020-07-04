package com.jramirez.soccerteamboard.service.repository

import com.jramirez.soccerteamboard.service.response.GetTeamNextEventsResponse

interface TeamNextEventRepository {
    suspend fun getTeamNextEvents(teamId: String) : GetTeamNextEventsResponse
}