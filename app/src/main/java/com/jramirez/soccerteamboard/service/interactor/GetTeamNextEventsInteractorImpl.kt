package com.jramirez.soccerteamboard.service.interactor

import com.jramirez.soccerteamboard.domain.Event
import com.jramirez.soccerteamboard.service.repository.TeamNextEventRepository
import com.jramirez.soccerteamboard.service.repository.TeamNextEventsRepositoryImpl

class GetTeamNextEventsInteractorImpl(
    override val teamNextEventRepository: TeamNextEventRepository = TeamNextEventsRepositoryImpl()
) : GetTeamNextEventsInteractor {
    override suspend fun execute(teamId: String): List<Event> =
        teamNextEventRepository.getTeamNextEvents(teamId).events
}