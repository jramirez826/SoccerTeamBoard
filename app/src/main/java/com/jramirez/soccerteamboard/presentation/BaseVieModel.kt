package com.jramirez.soccerteamboard.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseVieModel : ViewModel() {

    internal var errorLiveData = MutableLiveData<Boolean>()
    fun getErrorLiveData(): LiveData<Boolean> = errorLiveData

}