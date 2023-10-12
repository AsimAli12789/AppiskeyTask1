package com.example.appiskeytask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.appiskeytask.R
import com.example.appiskeytask.adapter.DataAdapter
import com.example.appiskeytask.databinding.ActivityMainBinding
import com.example.appiskeytask.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: DataViewModel by viewModels()
    private val adapter = DataAdapter(this, ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerview.adapter = adapter

        viewModel.images.observe(this) { imageDataList ->
           adapter.updateData(imageDataList)
        }

        viewModel.fetchImages("kitten")

    }
}