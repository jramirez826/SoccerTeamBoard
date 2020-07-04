package com.jramirez.soccerteamboard.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jramirez.soccerteamboard.databinding.ItemTeamBinding
import com.jramirez.soccerteamboard.domain.Team
import com.squareup.picasso.Picasso

class TeamsAdapter : RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {

    private var teams: List<Team> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder =
        TeamViewHolder(ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.bind(team)
    }

    fun setTeams(teams: List<Team>) {
        this.teams = teams
        notifyDataSetChanged()
    }

    inner class TeamViewHolder(private val binding: ItemTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(team: Team) {
            with(binding) {
                labTeamName.text = team.name
                labTeamStadium.text = team.stadium
                Picasso.get().load(team.badge).into(imgTeamBadge)
            }
        }
    }

}