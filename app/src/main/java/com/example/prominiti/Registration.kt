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
            getUsername()
        }

    }

    public fun getName(): String {
        name = nameField.text.toString()
        return name
    }

    public fun getUsername(): String {
        username = usernameField.text.toString()
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show()
        return username
    }

    public fun getEmail(): String {
        email = emailField.text.toString()
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show()
        return email
    }

    public fun getPassword(): String {
        password = passwordField.text.toString()
        Toast.makeText(this, password, Toast.LENGTH_SHORT).show()
        return password
    }

    public fun getConfirmPassword(): String {
        confirmPassword = nameField.text.toString()
        Toast.makeText(this, confirmPassword, Toast.LENGTH_SHORT).show()
        return confirmPassword
    }

    public fun register(){
        //This is a function for the server and registration
    }
}