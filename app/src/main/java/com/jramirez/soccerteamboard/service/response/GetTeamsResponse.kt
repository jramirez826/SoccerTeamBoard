package com.jramirez.soccerteamboard.service.response

import com.jramirez.soccerteamboard.domain.Team

data class GetTeamsResponse(val teams:List<Team>)