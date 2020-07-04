package com.jramirez.soccerteamboard.service.response

import com.jramirez.soccerteamboard.domain.Event

data class GetTeamNextEventsResponse(val events: List<Event>)