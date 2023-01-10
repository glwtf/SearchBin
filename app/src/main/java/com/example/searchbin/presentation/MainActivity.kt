package com.example.searchbin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.searchbin.R
import com.example.searchbin.databinding.ActivityMainBinding
import com.example.searchbin.presentation.recyclerview.BinInfoAdapter
import com.example.searchbin.presentation.viewModel.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private lateinit var rvAdapter: BinInfoAdapter

    private var _binding : ActivityMainBinding? = null
    private val binding : ActivityMainBinding
        get() = _binding ?: throw java.lang.RuntimeException("ActivityMainBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setRecycleView()
        viewModel.ldBinInfoList.observe(this) { item ->
            rvAdapter.submitList(item)
        }
    }

    private fun setRecycleView() {
        val rvSearchList = binding.rvSearchList
        with(rvSearchList) {
            rvAdapter = BinInfoAdapter()
            adapter = rvAdapter
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        rvAdapter.onSearchedItemClickListener = {
            launchFragmentBinInfo()
        }

        binding.buttonStartSearch.setOnClickListener {
            launchFragmentSearchBinInfo()
        }
    }

    private fun launchFragmentBinInfo() {

    }

    private fun launchFragmentSearchBinInfo() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}