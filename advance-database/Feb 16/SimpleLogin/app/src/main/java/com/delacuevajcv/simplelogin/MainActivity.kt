package com.delacuevajcv.simplelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var username = ""
    var password = ""

    val reqUser = "jcdelacueva"
    var reqPassword = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener {
            username = etUsername.text.toString()
            password = etPassword.text.toString()

            checkLoginCredentials(username, password)
        }
    }

    fun checkLoginCredentials(username: String, password: String) {
        if (username.isNotBlank() && password.isNotBlank()) {
            proceedToWelcomeActivity(username)
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }

    fun proceedToWelcomeActivity(username: String) {
        val intent = Intent(this, WelcomeActivity::class.java).apply {
            putExtra("name", username)
        }

        startActivity(intent)
    }
}
