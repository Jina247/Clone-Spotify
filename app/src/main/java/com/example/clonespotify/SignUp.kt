package com.example.clonespotify

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = Firebase.auth
        email = findViewById(R.id.emailField)
        password = findViewById(R.id.passwordField)
        password2 = findViewById(R.id.re_passwordField)
        signUpBtn = findViewById(R.id.signUpClickAction)
        signInBtn = findViewById(R.id.signInOption)

        signUpBtn.setOnClickListener {
            signUpUser()
        }
        signInBtn.setOnClickListener {
            navigateSignIn()
        }
    }
    private fun navigateSignIn() {
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
        finish()
    }
}