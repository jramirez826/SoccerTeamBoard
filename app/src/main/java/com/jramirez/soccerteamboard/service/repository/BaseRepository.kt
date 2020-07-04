package com.jramirez.soccerteamboard.service.repository

import com.jramirez.soccerteamboard.service.ResultServiceHandler
import com.jramirez.soccerteamboard.service.RetrofitClient
import com.jramirez.soccerteamboard.service.TeamsAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository(val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    val client: TeamsAPI = RetrofitClient.client

    suspend fun <T : Any> handleAPICall(
        clientCall: suspend () -> T
    ): ResultServiceHandler<T> {
        return withContext(dispatcher) {
            try {
                ResultServiceHandler.Success(clientCall.invoke())
            } catch (throwable: Throwable) {
                ResultServiceHandler.Error
            }
        }
    }
}