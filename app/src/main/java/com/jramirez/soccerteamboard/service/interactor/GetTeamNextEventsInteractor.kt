package com.jramirez.soccerteamboard.service.interactor

import com.jramirez.soccerteamboard.domain.Event
import com.jramirez.soccerteamboard.service.repository.TeamNextEventRepository

interface GetTeamNextEventsInteractor {
    val teamNextEventRepository: TeamNextEventRepository
    suspend fun execute(teamId: String): List<Event>
}