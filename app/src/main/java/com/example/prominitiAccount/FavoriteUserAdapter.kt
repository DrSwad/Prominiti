package com.example.prominitiAccount

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FavoriteUserAdapter(private var userlist: MutableList<SingleFavoriteUser>, val mListener: onContentClicklistener)
    : RecyclerView.Adapter<FavoriteUserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteUserAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_favorite_users, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: FavoriteUserAdapter.ViewHolder, position: Int) {
        val currentItem = userlist[position]
        holder.name.text = currentItem.profileName
        holder.username.text = currentItem.profileUsername
        holder.userImage.setImageResource(currentItem.profileImage)
        holder.copyImage.setImageResource(currentItem.copyImage)
        holder.deleteImage.setImageResource(currentItem.deleteImage)
    }

    override fun getItemCount(): Int {
        return userlist.size
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
                val position: Int = adapterPosition
                mListener.onCopyClick(position)
            }

            deleteImage.setOnClickListener{
                val position = adapterPosition
                mListener.onDeleteClick(position)
            }
        }
    }

    interface onContentClicklistener {
        fun onCopyClick(position: Int)
        fun onDeleteClick(position: Int)
    }
}