package com.jramirez.soccerteamboard.presentation.teamdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jramirez.soccerteamboard.service.interactor.GetTeamNextEventsInteractor
import com.jramirez.soccerteamboard.service.interactor.GetTeamNextEventsInteractorImpl
import kotlinx.coroutines.Dispatchers

class TeamDetailViewModel(
    private val getTeamNextEventsInteractor: GetTeamNextEventsInteractor = GetTeamNextEventsInteractorImpl(),
    private val teamId: String
) : ViewModel() {

    private var teamNextEventsLiveData = liveData(Dispatchers.IO) {
        val teams = getTeamNextEventsInteractor.execute(teamId)
        emit(teams)
    }

    fun getTeamNextEvents() = teamNextEventsLiveData
}
