package com.example.prominiti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FavoriteUsers : AppCompatActivity() {
    private lateinit var customLayoutManager: RecyclerView.LayoutManager
    private lateinit var customAdapter: RecyclerView.Adapter<FavoriteUserAdapter.ViewHolder>
    private lateinit var addButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_users)

        customLayoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.favoriteLayout)
        recyclerView.layoutManager = customLayoutManager
        customAdapter = FavoriteUserAdapter()
        recyclerView.adapter = customAdapter

        addButton = findViewById(R.id.add_button)

        addButton.setOnClickListener{
            //This functionality has to be done from the server
        }
    }
}