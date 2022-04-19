package com.example.prominitiTask


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prominitiAccount.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_task_list.*
import kotlinx.android.synthetic.main.delelte_alert_layout.*

class TaskList : AppCompatActivity(), TaskListAdapter.onItemClickListener {
    private lateinit var customLayoutManager: RecyclerView.LayoutManager
    private lateinit var customAdapter: RecyclerView.Adapter<TaskListAdapter.ViewHolder>

    private var taskList = generateTaskList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        customLayoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.task_layout)
        recyclerView.layoutManager = customLayoutManager
        customAdapter = TaskListAdapter(taskList,this)
        recyclerView.adapter = customAdapter

        val addTask: FloatingActionButton = findViewById(R.id.task_add_button)
        task_add_button.setOnClickListener{
            intent = Intent(this, LocationTask::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onEditClick(position: Int) {
        Toast.makeText(this, "asdasfa", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteClick(position: Int) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.delelte_alert_layout, null)
        val mBuidler = AlertDialog.Builder(this).setView(mDialogView).setTitle("Delete Confirmation")
        val mAlertDialog = mBuidler.show()

        mAlertDialog.fav_cancel.setOnClickListener {
            mAlertDialog.dismiss()
        }

        mAlertDialog.fav_okay.setOnClickListener {
            removeTask(position)
            customAdapter.notifyItemRemoved(position)
            mAlertDialog.dismiss()
        }
    }

    fun removeTask(position: Int) {
        taskList.removeAt(position)

        //Entry to be deleted from the database
    }

    private fun generateTaskList(): MutableList<SingleTask> {
        val tasks = ArrayList<SingleTask>()

        //This is just some test data for the layout, the real data will have to be brought from the database
        val titles: MutableList<String> = mutableListOf("Doing homework", "Wake up", "Eat medicines")
        val types: MutableList<String> = mutableListOf("t", "l", "t")
        val descriptions : MutableList<String> = mutableListOf("I need balance, need life, need determination, I must live up to my" +
                "reputation and be deterministic", "A", "B")
        val timestamps: MutableList<String> = mutableListOf("10:40", "15:30")
        val usernames: MutableList<String> = mutableListOf("dominga2025")

        var timeIndex = 0
        var locationIndex = 0

        titles.forEachIndexed { index, it ->
            if(types[index] == "t") {
                val task = SingleTask(titles[index], types[index], timestamps[timeIndex++],
                    descriptions[index], R.drawable.clock, R.drawable.colored_edit, R.drawable.goldel)
                tasks += task
            }
            else {
                val task = SingleTask(titles[index], types[index], usernames[locationIndex++],
                    descriptions[index], R.drawable.location, R.drawable.colored_edit, R.drawable.goldel)
                tasks += task
            }
        }

        return tasks
    }
}