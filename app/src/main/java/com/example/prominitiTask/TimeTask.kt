package com.example.prominitiTask

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import com.example.prominitiAccount.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import android.content.Intent
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_time_task.*
import java.util.*

class TimeTask : AppCompatActivity(), TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private lateinit var timeTitle: TextInputEditText
    private lateinit var timeDescription: TextInputEditText
    private lateinit var timeAdd: MaterialButton
    private lateinit var timepick: MaterialButton

    private var myDay: Int = 0
    private var myMonth: Int = 0
    private var myYear: Int = 0
    private var myhour: Int = 0
    private var myminute: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_task)

        timeTitle = findViewById(R.id.time_title_editText)
        timeDescription = findViewById(R.id.time_description_editText)
        timeAdd = findViewById(R.id.time_add)
        timepick = findViewById((R.id.time_pick_button))

        timeAdd.setOnClickListener {
            val title = timeTitle.text.toString()
            val description = timeDescription.text.toString()
            addTimeTask()
            val intent = Intent(this, TaskList::class.java)
            startActivity(intent)
            finish()
        }

        timepick.setOnClickListener {
            val calender : Calendar = Calendar.getInstance()
            val day = calender.get(Calendar.DAY_OF_MONTH)
            val month = calender.get(Calendar.MONTH)
            val year = calender.get(Calendar.YEAR)
            val datePickerDialog = DatePickerDialog(this, this, year, month, day)
            datePickerDialog.show()
        }
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        myYear = p1
        myMonth = p2
        myDay = p3
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this, this, hour, minute, DateFormat.is24HourFormat(this))
        timePickerDialog.show()
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        myhour = p1
        myminute = p2
        Toast.makeText(this, myMonth.toString(), Toast.LENGTH_SHORT).show()
        time_picker.text = "Date: " + myDay.toString() + " " + numberToMonth(myMonth) + ", "  + myYear.toString()
        time_shower.text = "Time: " + myhour.toString() + ":" + myminute.toString()
    }

    public fun addTimeTask() {
        //This is to be implemented
    }

    private fun numberToMonth(num: Int) : String {
        if(num == 0) {
            return "January"
        }
        else if(num == 1) {
            return "February"
        }
        else if(num == 2) {
            return "March"
        }
        else if(num == 3) {
            return "April"
        }
        else if(num == 4) {
            return "May"
        }
        else if(num == 5) {
            return "June"
        }
        else if(num == 6) {
            return "July"
        }
        else if(num == 7) {
            return "August"
        }
        else if(num == 8) {
            return "September"
        }
        else if(num == 9) {
            return "October"
        }
        else if(num == 10) {
            return "November"
        }
        else if(num == 11) {
            return "December"
        }
        else {
            return "April"
        }
    }
}