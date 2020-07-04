package com.jramirez.soccerteamboard.service.interactor

import com.jramirez.soccerteamboard.service.repository.TeamRepository
import com.jramirez.soccerteamboard.service.repository.TeamRepositoryImp

class GetTeamsInteractorImpl(override val teamRepository: TeamRepository = TeamRepositoryImp()) :GetTeamsInteractor{
    override suspend fun execute(leagueId: String) = teamRepository.getTeams(leagueId).teams
}