package com.ozancanguz.motivate_me_app.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozancanguz.motivate_me_app.databinding.ActivityLoginBinding
import com.ozancanguz.motivate_me_app.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.registerButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))

        }
    }
}