package com.medkissi.remotedatasourceappgroup2.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medkissi.remotedatasourceappgroup2.R
import com.medkissi.remotedatasourceappgroup2.adapters.PhotoAdapter
import com.medkissi.remotedatasourceappgroup2.adapters.PostAdapter
import com.medkissi.remotedatasourceappgroup2.utils.Resource
import com.medkissi.remotedatasourceappgroup2.viewmodels.PostViewModel

class MainActivity : AppCompatActivity() {
    val viewModel:PostViewModel by viewModels()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val layoutManager = LinearLayoutManager(this)
        val adapter = PhotoAdapter()
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = adapter
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textView  = findViewById<TextView>(R.id.msg_error)

        viewModel.getAllPhotos().observe(this){ state ->
           when(state){
               is Resource.Loading ->{
                   progressBar.visibility = View.VISIBLE
               }
               is Resource.Success ->{
                   adapter.submitList(state.data)
                   progressBar.visibility = View.GONE
               }
               is Resource.Error ->{
                   textView.visibility = View.VISIBLE
                   textView.text = state.message
                   progressBar.visibility = View.GONE

               }
           }

        }

    }
}