package com.jramirez.soccerteamboard.presentation.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jramirez.soccerteamboard.R
import com.jramirez.soccerteamboard.databinding.FragmentTeamsBinding
import com.jramirez.soccerteamboard.domain.Team
import com.jramirez.soccerteamboard.extensions.replaceFragment
import com.jramirez.soccerteamboard.presentation.MainActivity
import com.jramirez.soccerteamboard.presentation.teamdetail.TeamDetailFragment

class TeamsFragment : Fragment() {

    private lateinit var viewModel: TeamsViewModel
    private var _binding: FragmentTeamsBinding? = null
    private val binding get() = _binding!!
    private val teamsAdapter: TeamsAdapter = TeamsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecycler()
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this).get(TeamsViewModel::class.java)
        viewModel.getTeamsLiveData().observe(viewLifecycleOwner, Observer { teams ->
            teamsAdapter.setTeams(teams)
        })
        viewModel.getErrorLiveData().observe(viewLifecycleOwner, Observer { fail ->
            if (fail)
                Toast.makeText(context, R.string.error_message, Toast.LENGTH_SHORT).show()
        })
        viewModel.getTeams()
    }


    private fun setUpRecycler() {
        with(binding.recyclerTeams) {
            teamsAdapter.onItemClick = ::onItemClick
            layoutManager = LinearLayoutManager(context)
            adapter = teamsAdapter
        }
    }

    private fun onItemClick(team: Team) {
        val mainActivity = (activity as MainActivity)
        val fragment = TeamDetailFragment.newInstance(team)
        mainActivity.replaceFragment(
            mainActivity.binding.mainContainer.id,
            fragment
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = TeamsFragment()
    }
}
