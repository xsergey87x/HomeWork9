package com.example.homework9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<TextInputLayout>(R.id.login)
        val password = findViewById<TextInputLayout>(R.id.password)
        val loginT = findViewById<TextInputEditText>(R.id.loginText)
        val passwordT = findViewById<TextInputEditText>(R.id.passwordText)

        val sharPreferences = getSharedPreferences("main", Context.MODE_PRIVATE)

        fun test() {
            login.error = if (loginT.text.isNullOrEmpty()) {
                "login could not be empty"
            } else {
                null
            }
            password.error = if (passwordT.text.isNullOrEmpty()) {
                "password could not be empty"
            } else {
                null
            }

            if (loginT.text.toString() == "Admin") {
                sharPreferences.edit().putString("login", "Admin").apply()

                if (passwordT.text.toString() == "123456") {
                    sharPreferences.edit().putString("password", "123456").apply()
                    Toast.makeText(this, "Login and password are correct", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this, AcountActivity::class.java))
                    }, 2000)
                } else {
                    // Toast.makeText(this, "Password not correct", Toast.LENGTH_SHORT).show()
                    password.error = "Password are not correct"
                }

            } else {
                // Toast.makeText(this, "Login not correct", Toast.LENGTH_SHORT).show()
                login.error = "Login or login and password"
            }
        }

        passwordT.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    test()
                    true
                }
                else -> false

            }
        }
    }
}