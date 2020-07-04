package com.jramirez.soccerteamboard.presentation.teamdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jramirez.soccerteamboard.domain.Event
import com.jramirez.soccerteamboard.presentation.BaseVieModel
import com.jramirez.soccerteamboard.service.ResultServiceHandler
import com.jramirez.soccerteamboard.service.repository.TeamNextEventRepository
import com.jramirez.soccerteamboard.service.repository.TeamNextEventsRepositoryImpl
import kotlinx.coroutines.launch

class TeamDetailViewModel(
    private val teamId: String
) : BaseVieModel() {

    private val teamNextEventRepository: TeamNextEventRepository by lazy { TeamNextEventsRepositoryImpl() }
    private var teamNextEventsLiveData = MutableLiveData<List<Event>>()

    fun getTeamNextEventsLiveData(): LiveData<List<Event>> = teamNextEventsLiveData

    fun getTeamNextEvents() =
        viewModelScope.launch {
            val result = teamNextEventRepository.getTeamNextEvents(teamId)
            when (result) {
                is ResultServiceHandler.Success ->
                    teamNextEventsLiveData.postValue(result.value.events)
                is ResultServiceHandler.Error ->
                    errorLiveData.postValue(true)

            }
        }
}
