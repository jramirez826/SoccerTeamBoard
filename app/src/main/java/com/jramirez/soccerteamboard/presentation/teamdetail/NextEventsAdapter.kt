package com.jramirez.soccerteamboard.presentation.teamdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jramirez.soccerteamboard.databinding.ItemNextEventBinding
import com.jramirez.soccerteamboard.domain.Event

class NextEventsAdapter : RecyclerView.Adapter<NextEventsAdapter.NextEventViewHolder>() {

    private var events: List<Event> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextEventViewHolder =
        NextEventViewHolder(
            ItemNextEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: NextEventViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    fun setEvents(events: List<Event>) {
        this.events = events
        notifyDataSetChanged()
    }

    inner class NextEventViewHolder(private val binding: ItemNextEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event) {
            with(binding) {
                labEventName.text = event.name ?: ""
                labEventTime.text = event.time ?: ""
            }
        }
    }
}