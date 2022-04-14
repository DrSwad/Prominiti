package com.example.prominiti

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity()  {
    //UI attributes
    private lateinit var signupButton:MaterialButton
    private lateinit var loginButton: MaterialButton
    private lateinit var emailUsernameField: TextInputEditText
    private lateinit var passwordField: TextInputEditText

    //Class Attributes
    private lateinit var emailOrUsername: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signupButton = findViewById(R.id.login_signup)
        loginButton = findViewById(R.id.login_button)
        emailUsernameField = findViewById(R.id.email_username_editText)
        passwordField = findViewById(R.id.password_editText)

        signupButton.setOnClickListener {
            val intent: Intent = Intent(this, FavoriteUsers::class.java)
            startActivity(intent)
            finish()
        }

        loginButton.setOnClickListener{
            getPassword()
        }
    }

    public fun getEmailOrUserName():String {
        emailOrUsername = emailUsernameField.text.toString()
        return emailOrUsername
    }

    public fun getPassword(): String {
        password = passwordField.text.toString()
        Toast.makeText(this, password, Toast.LENGTH_SHORT).show()
        return password
    }

    public fun login() {
        //This is a function for the server and login
    }
}