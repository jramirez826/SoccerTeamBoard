package com.jramirez.soccerteamboard.presentation.teams

import androidx.recyclerview.widget.RecyclerView
import com.jramirez.soccerteamboard.databinding.ItemTeamBinding
import com.jramirez.soccerteamboard.domain.Team
import com.squareup.picasso.Picasso

class TeamViewHolder(private val binding: ItemTeamBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(team: Team, onItemClick: ((team: Team) -> Unit)?) {
        with(binding) {
            labTeamName.text = team.name
            labTeamStadium.text = team.stadium
            Picasso.get().load(team.badge).into(imgTeamBadge)
            root.setOnClickListener {
                onItemClick?.invoke(team)
            }
        }
    }
}