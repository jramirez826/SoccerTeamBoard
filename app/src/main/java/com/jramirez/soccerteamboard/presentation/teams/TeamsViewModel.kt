package com.jramirez.soccerteamboard.presentation.teams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jramirez.soccerteamboard.service.interactor.GetTeamsInteractor
import com.jramirez.soccerteamboard.service.interactor.GetTeamsInteractorImpl
import com.jramirez.soccerteamboard.constants.LeagueConstants
import kotlinx.coroutines.Dispatchers

class TeamsViewModel(private val getTeamsInteractor: GetTeamsInteractor = GetTeamsInteractorImpl()) :
    ViewModel() {

    private var teamsLiveData = liveData(Dispatchers.IO) {
        val teams = getTeamsInteractor.execute(LeagueConstants.LA_LIGA_ID)
        emit(teams)
    }

    fun getTeams() = teamsLiveData
}
