package com.example.prominitiTask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.prominitiAccount.R


class TaskListAdapter(private var taskList: MutableList<SingleTask>, private val listener: onItemClickListener)
    : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_tasklist, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: TaskListAdapter.ViewHolder, position: Int) {
        val currentTask = taskList[position]
        holder.title.text = currentTask.title
        holder.alertCondition.text = currentTask.alertCondition
        holder.descrption.text = currentTask.description
        holder.rowImage.setImageResource(currentTask.typeImage)
        holder.editImage.setImageResource(currentTask.editImage)
        holder.deleteImage.setImageResource(currentTask.deleteImage)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var rowImage: ImageView
        var title: TextView
        var alertCondition: TextView
        val descrption: TextView
        var editImage: ImageView
        var deleteImage: ImageView
        var expandButton: Button
        var expandLayout: ConstraintLayout

        init {
            rowImage = itemView.findViewById(R.id.row_image)
            title = itemView.findViewById(R.id.task_title)
            alertCondition = itemView.findViewById(R.id.task_reminder_condition)
            editImage = itemView.findViewById(R.id.row_edit)
            deleteImage = itemView.findViewById(R.id.task_delete)
            descrption = itemView.findViewById(R.id.task_description)
            expandButton = itemView.findViewById(R.id.expand_button)
            expandLayout = itemView.findViewById(R.id.expandable_layout)

            editImage.setOnClickListener {
                val position: Int = adapterPosition
                listener.onEditClick(position)
            }

            expandButton.setOnClickListener {
                if(expandLayout.visibility == View.GONE){
                    expandLayout.visibility = View.VISIBLE
                    expandButton.text = "Hide description"
                }
                else {
                    expandLayout.visibility = View.GONE
                    expandButton.text = "See Description"
                }
            }

            deleteImage.setOnClickListener {
                val position:Int = adapterPosition
                listener.onDeleteClick(position)
            }
        }
    }

    interface onItemClickListener {
        fun onEditClick(position: Int)
        fun onDeleteClick(position: Int)
    }
}