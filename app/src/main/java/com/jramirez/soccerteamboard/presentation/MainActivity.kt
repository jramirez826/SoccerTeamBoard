package com.jramirez.soccerteamboard.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jramirez.soccerteamboard.databinding.ActivityMainBinding
import com.jramirez.soccerteamboard.presentation.teams.TeamsFragment
import com.jramirez.soccerteamboard.extensions.replaceFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(
            binding.mainContainer.id,
            TeamsFragment.newInstance()
        )
    }
}
