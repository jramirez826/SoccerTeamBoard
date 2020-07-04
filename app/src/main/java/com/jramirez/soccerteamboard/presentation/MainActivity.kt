package com.jramirez.soccerteamboard.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jramirez.soccerteamboard.databinding.ActivityMainBinding
import com.jramirez.soccerteamboard.utils.addFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addFragment(binding.mainContainer.id, TeamsFragment())
    }
}
