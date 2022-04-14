package com.example.prominiti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoriteUsers : AppCompatActivity() {
    private lateinit var customLayoutManager: RecyclerView.LayoutManager
    private lateinit var customAdapter: RecyclerView.Adapter<FavoriteUserAdapter.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_users)

        customLayoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.favoriteLayout)
        recyclerView.layoutManager = customLayoutManager
        customAdapter = FavoriteUserAdapter()
        recyclerView.adapter = customAdapter
    }
}