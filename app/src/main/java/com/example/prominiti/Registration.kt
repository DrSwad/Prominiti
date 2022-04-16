package com.example.prominiti

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Registration: AppCompatActivity() {
    //UI attributes
    private lateinit var regButton: MaterialButton
    private lateinit var nameField: TextInputEditText
    private lateinit var usernameField: TextInputEditText
    private lateinit var emailField: TextInputEditText
    private lateinit var passwordField: TextInputEditText
    private lateinit var confirmPasswordField: TextInputEditText

    //class attributes
    private lateinit var name: String
    private lateinit var username: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var confirmPassword: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_registration)

        regButton = findViewById(R.id.register_button)
        nameField = findViewById(R.id.name_editText)
        usernameField = findViewById(R.id.username_editText)
        emailField = findViewById(R.id.email_editText)
        passwordField = findViewById(R.id.password_signup_editText)
        confirmPasswordField = findViewById(R.id.confirmPassword_editText)

        regButton.setOnClickListener{
            register()
        }

    }

    public fun getName(): String {
        return name
    }

    public fun setName(_name: String){
        name = _name
    }

    public fun getUsername(): String {
        return username
    }

    public fun setUsername(_username: String){
        username = _username
    }

    public fun getEmail(): String {
        return email
    }

    public fun setEmail(_email: String) {
        email = _email
    }

    public fun getPassword(): String {
        return password
    }

    public fun setPassword(_password: String) {
        password = _password
    }

    public fun getConfirmPassword(): String {
        return confirmPassword
    }

    public fun setConfirmPassword(_confirmPassword: String){
        confirmPassword = _confirmPassword
    }

    public fun register(){
        //This is a function for the server and registration
        setName(nameField.text.toString())
        setUsername(usernameField.text.toString())
        setEmail(emailField.text.toString())
        setPassword(passwordField.text.toString())
        setConfirmPassword(confirmPasswordField.text.toString())

        //The rest is to be coded here

    }
}