package com.jramirez.soccerteamboard.presentation.teamdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TeamDetailViewModelFactory(private val teamId: String) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeamDetailViewModel(teamId = teamId) as T
    }
}