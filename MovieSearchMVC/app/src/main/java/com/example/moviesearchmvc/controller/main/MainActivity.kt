package com.example.moviesearchmvc.controller.main

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearchmvc.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity :AppCompatActivity() {

    private lateinit var fab: FloatingActionButton
    private lateinit var noMoviesLayout: LinearLayout
    private lateinit var moviesRecyclerView: RecyclerView

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
    }

    private fun setupViews() {
        moviesRecyclerView = findViewById(R.id.movies_recyclerview)
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        fab = findViewById(R.id.fab)
        noMoviesLayout = findViewById(R.id.no_movies_layout)
        supportActionBar?.title = "看电影"
    }
}

