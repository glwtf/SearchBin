package com.example.searchbin.presentation

import android.os.Bundle
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
            val validBin = validateBin(bin)
            if (validBin) {
                viewModel.searchBinInfo(bin).observe(viewLifecycleOwner) { binInfo ->
                    launchFragmentBinInfo(binInfo)
                }
            }

        }
    }

    private fun validateBin(bin : String) : Boolean {
        var ret = true
        //TODO: add validate
        return ret
    }

    private fun launchFragmentBinInfo(binInfo: BinInfo) {
        findNavController().navigate(
            SearchBinInfoFragmentDirections.actionSearchBinInfoFragmentToBinInfoFragment(binInfo)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}