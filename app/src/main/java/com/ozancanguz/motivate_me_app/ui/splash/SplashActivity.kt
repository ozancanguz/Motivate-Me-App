package com.ozancanguz.motivate_me_app.ui.splash



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.ui.login.LoginActivity
import com.ozancanguz.motivate_me_app.ui.main.MainActivity

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        val background = object : Thread() {
            override fun run() {
                try {

                    Thread.sleep(5000)
                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}