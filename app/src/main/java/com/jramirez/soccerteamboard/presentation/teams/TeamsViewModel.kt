package com.jramirez.soccerteamboard.presentation.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jramirez.soccerteamboard.constants.LeagueConstants
import com.jramirez.soccerteamboard.domain.Team
import com.jramirez.soccerteamboard.presentation.BaseVieModel
import com.jramirez.soccerteamboard.service.ResultServiceHandler
import com.jramirez.soccerteamboard.service.repository.TeamRepository
import com.jramirez.soccerteamboard.service.repository.TeamRepositoryImp
import kotlinx.coroutines.launch

class TeamsViewModel :
    BaseVieModel() {

    private val teamRepository: TeamRepository by lazy { TeamRepositoryImp() }
    private var teamsLiveData = MutableLiveData<List<Team>>()

    fun getTeamsLiveData(): LiveData<List<Team>> = teamsLiveData

    fun getTeams() =
        viewModelScope.launch {
            val result = teamRepository.getTeams(LeagueConstants.LA_LIGA_ID)
            when (result) {
                is ResultServiceHandler.Success ->
                    teamsLiveData.postValue(result.value.teams)
                is ResultServiceHandler.Error ->
                    errorLiveData.postValue(true)

            }
        }
}
