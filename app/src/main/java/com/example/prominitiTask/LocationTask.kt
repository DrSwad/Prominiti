package com.example.prominitiTask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListAdapter
import com.example.prominitiAccount.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LocationTask : AppCompatActivity() {

    private lateinit var locTitle: TextInputEditText
    private lateinit var locDescription: TextInputEditText
    private lateinit var locDistance: TextInputEditText
    private lateinit var targetUserField: TextInputLayout
    private lateinit var userDropDown: AutoCompleteTextView
    private lateinit var locAdd: MaterialButton

    private lateinit var userList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_location_task)

        locTitle = findViewById(R.id.loc_title_editText)
        locDescription = findViewById(R.id.loc_descrption_editText)
        locDistance = findViewById(R.id.loc_distance_editText)
        targetUserField = findViewById(R.id.location_target_user)
        userDropDown = findViewById(R.id.location_target_user_editText)
        locAdd = findViewById(R.id.loc_add)

        userList = generateUserList()
        val adapter = ArrayAdapter(this, R.layout.dropdown_item, userList)
        userDropDown.setAdapter(adapter)

        locAdd.setOnClickListener {
            val title: String = locTitle.text.toString()
            val descrption: String = locDescription.text.toString()
            val distance: String = locDistance.text.toString()
            val targetUser: String = userDropDown.text.toString()

            addLocationTask()
            val intent = Intent(this, TaskList::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun generateUserList(): Array<String> {

        //The favorite userlist must be fetched from the database
        val users = arrayOf("farhan2021", "kmAzwad", "ami999")
        return users
    }

    fun addLocationTask() {
        // This is to be implemented
    }
}