package com.example.prominiti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class UserProfile : AppCompatActivity() {
    private lateinit var logoutButton: MaterialButton
    private lateinit var favoriteUserButton: MaterialButton
    private lateinit var profileName: TextView
    private lateinit var profileUsername: MaterialTextView
    private lateinit var profileEmail: MaterialTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        logoutButton = findViewById(R.id.logout_btn)
        favoriteUserButton = findViewById(R.id.favorite_users_button)
        profileName = findViewById(R.id.profile_name)
        profileUsername = findViewById(R.id.profile_username)
        profileEmail = findViewById(R.id.profile_email)

        //Set the texts accordingly from the data from the database


        //logout functionality
        logoutButton.setOnClickListener{

        }

        favoriteUserButton.setOnClickListener {
            val intent = Intent(this, FavoriteUsers::class.java)
            startActivity(intent)
            finish()
        }
    }
}