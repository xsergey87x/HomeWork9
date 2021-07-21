package com.example.homework9

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AcountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acount)

        val sharPreferences = getSharedPreferences("main", Context.MODE_PRIVATE)
        val loginView = findViewById<TextView>(R.id.idLogin)
        val passwordView = findViewById<TextView>(R.id.idPassword)

        val login1 = sharPreferences.getString("login", "0")
        val password1 = sharPreferences.getString("password", "0")

        loginView.text = login1
        passwordView.text = password1

    }
}