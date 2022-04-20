package com.example.prominitiAccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.example.prominitiTask.TaskList
import kotlinx.android.synthetic.main.al_layout.*

class UserProfile : AppCompatActivity() {
    private lateinit var logoutButton: MaterialButton
    private lateinit var favoriteUserButton: MaterialButton
    private lateinit var profileName: TextView
    private lateinit var profileUsername: MaterialTextView
    private lateinit var profileEmail: MaterialTextView

    private lateinit var name: String
    private lateinit var username: String
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        logoutButton = findViewById(R.id.logout_btn)
        favoriteUserButton = findViewById(R.id.favorite_users_button)

        profileName = findViewById(R.id.profile_name)
        profileUsername = findViewById(R.id.profile_username)
        profileEmail = findViewById(R.id.profile_email)

        //Set the values accordingly from the data from the database


        //logout functionality
        logoutButton.setOnClickListener{
            logout()
        }

        favoriteUserButton.setOnClickListener {
            val intent = Intent(this, FavoriteUsers::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.test_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.bot_task -> {
                intent = Intent(this, TaskList::class.java)
                startActivity(intent)
                finish()
                return true
            }
            R.id.bot_profile-> {
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    public fun getName(): String {
        name = profileName.text.toString()
        return name
    }

    public fun getUsername(): String {
        username = profileUsername.text.toString()
        return username
    }

    public fun getEmail(): String {
        email = profileEmail.text.toString()
        return email
    }

    public fun logout() {
        // This function is to be implemented by the server
    }

    private fun showDialog() {
        val mDialogView =
            LayoutInflater.from(this).inflate(R.layout.favorite_user_alert_layout, null)
        val mBuidler = AlertDialog.Builder(this).setView(mDialogView).setTitle("Reminder")
        val mAlertDialog = mBuidler.show()

        mAlertDialog.okbtn.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }
}