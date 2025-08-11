package com.example.clonespotify

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.textservice.TextInfo
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlin.math.log

class SignIn : AppCompatActivity() {
    private lateinit var emailAndUsername : TextInputEditText
    private lateinit var password : TextInputEditText
    private lateinit var loginButton : Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = Firebase.auth
        emailAndUsername = findViewById(R.id.emailEditText)
        password = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginClickButton)

        val email : String = emailAndUsername.toString()
        val pass : String = password.toString()

        loginButton.setOnClickListener { v ->
            auth.signInWithEmailAndPassword(email, pass )
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithEmail: Success")
                        val user = auth.currentUser
                        showUI(user)
                    }
                    else {
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                        showUI(null)
                    }
                }
        }
    }
    private fun showUI(user: FirebaseUser?) {
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
        finish()
    }
    private fun loginUser() {
        val email : String = emailAndUsername.text.toString().trim()
        val pass : String = password.text.toString().trim()

        if (email.isEmpty()) {
            emailAndUsername.error = "Email is required!"
            emailAndUsername.requestFocus()
            return
        }
        if (pass.isEmpty()) {
            password.error = "Password is required!"
            password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(email, pass )
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Success!")
                    val user = auth.currentUser
                    showUI(user)
                }
                else {
                    Log.w(TAG, "Please sign up", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    finish()
                }
            }
    }

}