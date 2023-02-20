package com.ozancanguz.motivate_me_app.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozancanguz.motivate_me_app.databinding.ActivityLoginBinding
import com.ozancanguz.motivate_me_app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}