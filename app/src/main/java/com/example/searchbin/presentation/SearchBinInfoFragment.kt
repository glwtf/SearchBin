package com.example.searchbin.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.searchbin.databinding.FragmentSearchBinInfoBinding
import com.example.searchbin.domain.BinInfo
import com.example.searchbin.presentation.viewModel.SearchBinInfoViewModel

class SearchBinInfoFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[SearchBinInfoViewModel::class.java]
    }

    private var _binding : FragmentSearchBinInfoBinding? = null
    private val binding : FragmentSearchBinInfoBinding
        get() = _binding ?: throw java.lang.RuntimeException("FragmentSearchBinInfoBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchButton.setOnClickListener {
        val bin = binding.etBin.text.toString()
            viewModel.searchBinInfo(bin).observe(viewLifecycleOwner) { binInfo ->
                if (binInfo.bin != 0) {
                    launchFragmentBinInfo(binInfo)
                }
            }
        }
        setTextChangeListener()
        setErrorListener()
    }

    private fun launchFragmentBinInfo(binInfo: BinInfo) {
        findNavController().navigate(
            SearchBinInfoFragmentDirections.actionSearchBinInfoFragmentToBinInfoFragment(binInfo)
        )
    }

    private fun setTextChangeListener() {
        binding.etBin.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputBin()
            }

            override fun afterTextChanged(s: Editable?) { }

        })
    }

    private fun setErrorListener() {
        viewModel.errorInputBin.observe(viewLifecycleOwner) { state ->
            if (state == true) {
                binding.tilBin.error = "Wrong BIN type!"
            }
            else {
                binding.tilBin.error = null
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}