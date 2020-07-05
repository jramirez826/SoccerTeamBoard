package com.jramirez.soccerteamboard.presentation.teamdetail

import androidx.recyclerview.widget.RecyclerView
import com.jramirez.soccerteamboard.databinding.ItemNextEventBinding
import com.jramirez.soccerteamboard.domain.Event

class NextEventViewHolder(private val binding: ItemNextEventBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(event: Event) {
        with(binding) {
            labEventName.text = event.name ?: ""
            labEventTime.text = event.time ?: ""
        }
    }
}
