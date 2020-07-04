package com.jramirez.soccerteamboard.service.interactor

import com.jramirez.soccerteamboard.domain.Team
import com.jramirez.soccerteamboard.service.repository.TeamRepository

interface GetTeamsInteractor {

    val teamRepository: TeamRepository
    suspend fun execute(leagueId: String): List<Team>

}