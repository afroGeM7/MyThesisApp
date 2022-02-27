package com.gemmausiku.mythesis

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.ui.AppBarConfiguration

import com.gemmausiku.mythesis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

    }









}