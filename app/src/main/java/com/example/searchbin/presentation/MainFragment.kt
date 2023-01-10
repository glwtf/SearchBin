package com.example.searchbin.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.searchbin.R
import com.example.searchbin.databinding.ActivityMainBinding
import com.example.searchbin.databinding.FragmentMainBinding
import com.example.searchbin.domain.BinInfo
import com.example.searchbin.presentation.recyclerview.BinInfoAdapter
import com.example.searchbin.presentation.viewModel.MainViewModel


class MainFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private lateinit var rvAdapter: BinInfoAdapter
    private var _binding : FragmentMainBinding? = null
    private val binding : FragmentMainBinding
        get() = _binding ?: throw java.lang.RuntimeException("FragmentMainBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycleView()
        viewModel.ldBinInfoList.observe(viewLifecycleOwner) { item ->
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
        rvAdapter.onSearchedItemClickListener = { binInfo ->
            launchFragmentBinInfo(binInfo)
        }

        binding.buttonStartSearch.setOnClickListener {
            launchFragmentSearchBinInfo()
        }
    }

    private fun launchFragmentBinInfo(binInfo: BinInfo) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToBinInfoFragment(binInfo)
        )
    }

    private fun launchFragmentSearchBinInfo() {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToSearchBinInfoFragment()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}