package com.ozancanguz.motivate_me_app.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozancanguz.motivate_me_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}