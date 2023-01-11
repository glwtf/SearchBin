package com.example.searchbin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.searchbin.databinding.FragmentBinInfoBinding

class BinInfoFragment : Fragment() {

    private val args by navArgs<BinInfoFragmentArgs>()

    private var _binding : FragmentBinInfoBinding? = null
    private val binding : FragmentBinInfoBinding
        get() = _binding ?: throw java.lang.RuntimeException("FragmentSearchBinInfoBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBinInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}