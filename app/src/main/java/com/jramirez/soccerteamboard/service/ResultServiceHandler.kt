package com.jramirez.soccerteamboard.service

sealed class ResultServiceHandler<out T> {
    data class Success<out T>(val value : T) : ResultServiceHandler<T>()
    object Error: ResultServiceHandler<Nothing>()
}