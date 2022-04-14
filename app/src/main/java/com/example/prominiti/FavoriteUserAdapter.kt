package com.example.prominiti

import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity


class FavoriteUserAdapter: RecyclerView.Adapter<FavoriteUserAdapter.ViewHolder>() {
    //This is just some test data for the layout, the real data will have to be brought from the database
    private var names: MutableList<String> = mutableListOf("Farhan", "Monon", "Jawad", "Swad")
    private var usernames: MutableList<String> = mutableListOf("farhan2021", "monon3031", "jrmrmh", "drswad")

    //The images will be unchanged
    private var personImages: MutableList<Int> = mutableListOf()
    private var copyImages: MutableList<Int> =  mutableListOf()
    private var deleteImages:MutableList<Int> = mutableListOf()

    init {
        for (i in names) {
            personImages.add(R.drawable.ic_man_icon_vector_silhouette_front_260nw_544746175__1_)
            copyImages.add(R.drawable.ic_baseline_content_copy_24)
            deleteImages.add(R.drawable.ic_baseline_delete_24)
        }
    }




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteUserAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_favorite_users, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: FavoriteUserAdapter.ViewHolder, position: Int) {
        holder.name.text = names[position]
        holder.username.text = usernames[position]
        holder.userImage.setImageResource(personImages[position])
        holder.copyImage.setImageResource(copyImages[position])
        holder.deleteImage.setImageResource(deleteImages[position])
    }

    override fun getItemCount(): Int {
        return names.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var userImage: ImageView
        var name: TextView
        var username: TextView
        var copyImage: ImageView
        var deleteImage: ImageView

        init {
            userImage = itemView.findViewById(R.id.user_icon)
            name = itemView.findViewById(R.id.name)
            username = itemView.findViewById(R.id.username)
            copyImage = itemView.findViewById(R.id.usernameCopy)
            deleteImage = itemView.findViewById(R.id.userDelete)

            copyImage.setOnClickListener {
//                val position: Int = adapterPosition
//                val clipboard:ClipboardManager =
            }

            deleteImage.setOnClickListener {
                val position: Int = adapterPosition
                names.removeAt(position)
                usernames.removeAt(position)
                personImages.removeAt(position)
                copyImages.removeAt(position)
                deleteImages.removeAt(position)
            }
        }
    }

}