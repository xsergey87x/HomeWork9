package com.example.homework9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharPreferences = getSharedPreferences("main", Context.MODE_PRIVATE)

        val login = sharPreferences.getString("login", "0")
        val password = sharPreferences.getString("password", "0")

        Handler(Looper.getMainLooper()).postDelayed({
            if ((login == "Admin") && (password == "123456")) {
                startActivity(Intent(this, AcountActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }

        }, 2000)
    }
}