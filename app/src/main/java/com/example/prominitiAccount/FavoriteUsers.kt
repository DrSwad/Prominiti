package com.example.prominitiAccount

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.delelte_alert_layout.*
import kotlinx.android.synthetic.main.favorite_user_alert_layout.view.*

class FavoriteUsers : AppCompatActivity(), FavoriteUserAdapter.onContentClicklistener {
    private lateinit var customLayoutManager: RecyclerView.LayoutManager
    private lateinit var customAdapter: RecyclerView.Adapter<FavoriteUserAdapter.ViewHolder>
    private lateinit var addButton: FloatingActionButton

    var userList = generateUserList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_users)

        customLayoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.favoriteLayout)
        recyclerView.layoutManager = customLayoutManager
        customAdapter = FavoriteUserAdapter(userList, this)
        recyclerView.adapter = customAdapter
        recyclerView.setHasFixedSize(true)

        addButton = findViewById(R.id.add_button)

        addButton.setOnClickListener{
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.favorite_user_alert_layout, null)
            val mBuidler = AlertDialog.Builder(this).setView(mDialogView).setTitle("Add user")
            val mAlertDialog = mBuidler.show()

            mDialogView.fav_alert_addbtn.setOnClickListener{
                addUser(mDialogView.fav_alert_username.text.toString())
                customAdapter.notifyItemInserted(userList.size-1)
                mAlertDialog.dismiss()
            }
        }
    }

    fun addUser(username: String) {

        //A random name(username.uppercase) value is used here, in reality it will have to be fetched from the server
        val newUser = SingleFavoriteUser(R.drawable.profile2, username.uppercase(), username,
        R.drawable.ic_baseline_content_copy_24, R.drawable.blue_delete)
        userList.add(newUser)

        //Upload to database functionality to be implemented
    }

    fun removeUser(position: Int) {
        userList.removeAt(position)

        //Data in database must also be changed, that is to be implemented
    }

    override fun onCopyClick(position: Int) {
        val clipboard: ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("username", userList[position].profileUsername)
        clipboard.setPrimaryClip(clipData)
        Toast.makeText(this, "Username copied", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteClick(position: Int) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.delelte_alert_layout, null)
        val mBuidler = AlertDialog.Builder(this).setView(mDialogView).setTitle("Delete Confirmation")
        val mAlertDialog = mBuidler.show()

        mAlertDialog.fav_cancel.setOnClickListener {
            mAlertDialog.dismiss()
        }

        mAlertDialog.fav_okay.setOnClickListener {
            removeUser(position)
            customAdapter.notifyItemRemoved(position)
            mAlertDialog.dismiss()
        }
    }

    private fun generateUserList(): MutableList<SingleFavoriteUser>{
        val userList = ArrayList<SingleFavoriteUser>()

        //These data to be added from the database
        var names: MutableList<String> = mutableListOf("Farhan", "Monon", "Jawad", "Swad")
        var usernames: MutableList<String> = mutableListOf("farhan2021", "monon3031", "jrmrmh", "drswad")

        names.forEachIndexed { index, it ->
            val user = SingleFavoriteUser(
                R.drawable.profile2, names[index], usernames[index],
                R.drawable.ic_baseline_content_copy_24, R.drawable.blue_delete
            )
            userList += user
        }
        return userList
    }
}