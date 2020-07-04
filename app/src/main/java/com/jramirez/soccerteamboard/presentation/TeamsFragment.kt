package com.jramirez.soccerteamboard.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jramirez.soccerteamboard.databinding.FragmentTeamsBinding

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
        viewModel = ViewModelProvider(this).get(TeamsViewModel::class.java)
        viewModel.getTeams().observe(viewLifecycleOwner, Observer { teams ->
            teamsAdapter.setTeams(teams)
        })
    }

    private fun setUpRecycler() {
        with(binding.recyclerTeams) {
            layoutManager = LinearLayoutManager(context)
            adapter = teamsAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
