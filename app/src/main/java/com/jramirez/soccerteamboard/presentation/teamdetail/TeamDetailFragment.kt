package com.jramirez.soccerteamboard.presentation.teamdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jramirez.soccerteamboard.databinding.FragmentTeamDetailBinding
import com.jramirez.soccerteamboard.domain.Team
import com.squareup.picasso.Picasso

class TeamDetailFragment(private val team: Team? = null) : Fragment() {

    private lateinit var viewModel: TeamDetailViewModel
    private var _binding: FragmentTeamDetailBinding? = null
    private val binding get() = _binding!!
    private val nextEventsAdapter: NextEventsAdapter = NextEventsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecycler()
        bindView()
        viewModel = ViewModelProvider(
            this,
            TeamDetailViewModelFactory(team?.id ?: "")
        ).get(TeamDetailViewModel::class.java)

        viewModel.getTeamNextEvents().observe(viewLifecycleOwner, Observer { events ->
            nextEventsAdapter.setEvents(events)
        })
    }

    private fun setUpRecycler() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = nextEventsAdapter
        }
    }

    private fun bindView() {
        Log.d("team", team?.toString())
        with(binding) {
            labTeamName.text = team?.name
            labFoundationYear.text = team?.foundation
            labTeamDescription.text = team?.description
            Picasso.get().load(team?.badge).into(imgTeamBadge)
            Picasso.get().load(team?.jersey).into(imgTeamJersey)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(team: Team) = TeamDetailFragment(team)
    }
}
