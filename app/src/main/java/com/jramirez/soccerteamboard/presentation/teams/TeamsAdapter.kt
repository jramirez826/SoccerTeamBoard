package com.jramirez.soccerteamboard.presentation.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jramirez.soccerteamboard.databinding.ItemTeamBinding
import com.jramirez.soccerteamboard.domain.Team
import com.squareup.picasso.Picasso

class TeamsAdapter : RecyclerView.Adapter<TeamViewHolder>() {

    private var teams: List<Team> = emptyList()
    var onItemClick: ((team: Team) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder =
        TeamViewHolder(ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.bind(team, onItemClick)
    }

    fun setTeams(teams: List<Team>) {
        this.teams = teams
        notifyDataSetChanged()
    }

}