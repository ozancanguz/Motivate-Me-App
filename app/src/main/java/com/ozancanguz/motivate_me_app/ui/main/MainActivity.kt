package com.ozancanguz.motivate_me_app.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }
}