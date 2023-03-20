package com.ozancanguz.motivate_me_app.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.motivate_me_app.databinding.ActivityLoginBinding
import com.ozancanguz.motivate_me_app.ui.main.MainActivity
import com.ozancanguz.motivate_me_app.ui.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        FirebaseApp.initializeApp(this)
        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.registerButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))

        }


        //login
        login()

        // current user
        val currentUser=auth.currentUser
        if(currentUser!=null){
            binding.pb.visibility=View.VISIBLE
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
            binding.pb.visibility=View.INVISIBLE
        }



    }

    private fun login() {
        binding.loginButton.setOnClickListener {
            binding.pb.visibility= View.VISIBLE
            val email=binding.emailEditText.text.toString()
            val password=binding.passwordEditText.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,"E-mail or password empty",Toast.LENGTH_LONG).show()
                binding.pb.visibility= View.INVISIBLE
            }else{


                    auth.signInWithEmailAndPassword(email, password).addOnSuccessListener{

                        val intent= Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        binding.pb.visibility= View.INVISIBLE
                    }.addOnFailureListener {
                        Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                    }
            }
        }
    }
}