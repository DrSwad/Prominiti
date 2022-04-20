package com.example.prominitiTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.prominitiAccount.R
import kotlinx.android.synthetic.main.al_layout.*

class DestinationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)
        showDialog()
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