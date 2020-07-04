package com.jramirez.soccerteamboard.service

import com.jramirez.soccerteamboard.service.response.GetTeamNextEventsResponse
import com.jramirez.soccerteamboard.service.response.GetTeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamsAPI {

    @GET("lookup_all_teams.php")
    suspend fun getTeams(@Query("id") leagueId: String): GetTeamsResponse

    @GET("eventsnext.php")
    suspend fun getTeamNextEvents(@Query("id") teamId: String): GetTeamNextEventsResponse
}