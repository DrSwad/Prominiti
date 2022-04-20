package com.example.prominitiTask

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListAdapter
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.example.prominitiAccount.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.al_layout.*

class LocationTask : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

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

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

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
            fetchPermission()

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

    private fun fetchPermission(){
        val task:Task<Location> = fusedLocationProviderClient.lastLocation

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
            return
        }

        task.addOnSuccessListener {
            if(it != null) {
                val latitude: String = it.latitude.toString()
                val longitude: String = it.longitude.toString()

                //
            }
        }
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