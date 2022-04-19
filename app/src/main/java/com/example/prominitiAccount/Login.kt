package com.example.prominitiAccount

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.example.prominitiTask.TaskList

class Login : AppCompatActivity()  {
    //UI attributes
    private lateinit var signupButton:MaterialButton
    private lateinit var loginButton: MaterialButton
    private lateinit var emailUsernameField: TextInputEditText
    private lateinit var passwordField: TextInputEditText
    private lateinit var logoImage: ImageView

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
        logoImage = findViewById(R.id.login_logo)

        signupButton.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
            finish()
        }

        loginButton.setOnClickListener{
            login()
            val intent = Intent(this, TaskList::class.java)
            startActivity(intent)
        }
    }

    public fun getEmailOrUserName():String {
        return emailOrUsername
    }

    public fun setEmailOrUsername(_emailOrUsername: String) {
        emailOrUsername = _emailOrUsername
    }

    public fun getPassword(): String {
        return password
    }

    public fun setPassword(_password: String) {
       password = _password
    }

    public fun login() {
        //This is a function for the server and login
        setEmailOrUsername(emailUsernameField.text.toString())
        setPassword(passwordField.text.toString())

        //The rest is to be coded here

    }
}