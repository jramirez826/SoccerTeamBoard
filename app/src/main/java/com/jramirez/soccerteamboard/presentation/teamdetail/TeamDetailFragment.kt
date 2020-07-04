package com.jramirez.soccerteamboard.presentation.teamdetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.*
import android.widget.ImageView
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jramirez.soccerteamboard.databinding.FragmentTeamDetailBinding
import com.jramirez.soccerteamboard.domain.Team
import com.jramirez.soccerteamboard.extensions.getSocialMedia
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
        setUpViewModel()
    }

    private fun setUpViewModel() {
        team?.id?.let {
            viewModel = ViewModelProvider(
                this,
                TeamDetailViewModelFactory(team.id)
            ).get(TeamDetailViewModel::class.java)

            viewModel.getTeamNextEvents().observe(viewLifecycleOwner, Observer { events ->
                nextEventsAdapter.setEvents(events)
            })
        }
    }

    private fun setUpRecycler() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = nextEventsAdapter
        }
    }

    private fun bindView() {
        with(binding) {
            labTeamName.text = team?.name ?: ""
            labFoundationYear.text = team?.foundation ?: ""
            labTeamDescription.text = team?.description ?: ""
            team?.badge?.let { Picasso.get().load(it).into(imgTeamBadge) }
            team?.jersey?.let { Picasso.get().load(it).into(imgTeamJersey) }
            team?.getSocialMedia()?.forEach { socialMedia ->
                val socialImage = ImageView(context)
                val params = ViewGroup.MarginLayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                params.setMargins(8, 8, 8, 8)
                socialImage.setImageResource(socialMedia.icon)
                socialImage.setOnClickListener { loadURL(socialMedia.url) }
                socialImage.layoutParams = params
                socialMediaContainer.addView(socialImage)
            }
        }
    }

    private fun loadURL(socialUrl: String) {
        var url = socialUrl
        if (!socialUrl.startsWith("https://") && !socialUrl.startsWith("http://")) {
            url = "http://$socialUrl"
        }
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(team: Team) = TeamDetailFragment(team)
    }
}
