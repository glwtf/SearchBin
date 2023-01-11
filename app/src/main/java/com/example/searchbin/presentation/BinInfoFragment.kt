package com.example.searchbin.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.searchbin.databinding.FragmentBinInfoBinding
import com.example.searchbin.presentation.viewModel.BinInfoViewModel

class BinInfoFragment : Fragment() {

    private val args by navArgs<BinInfoFragmentArgs>()
    private val viewModel by lazy {
        ViewModelProvider(this)[BinInfoViewModel::class.java]
    }

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
        setView()
        //setClick()
        //observeGetItem(args.binInfo.bin)
    }

    private fun setView() {
        with (binding) {
            tvSchemeNetwork.text = args.binInfo.scheme
            tvBrand.text = args.binInfo.brand
            tvLength.text = args.binInfo.number.length.toString()
            tvLuhn.text = args.binInfo.number.luhn.toString()
            tvType.text = args.binInfo.type
            tvPrepaid.text = args.binInfo.prepaid.toString()
            tvCountry.text = args.binInfo.country.nameCountry
            tvBank.text = args.binInfo.bank.nameBank
            tvCity.text = args.binInfo.bank.city
            tvUrl.text = args.binInfo.bank.url
            tvPhone.text = args.binInfo.bank.phone
        }
    }

    /*private fun observeGetItem(bin : Int) {
        viewModel.getBinInfoItem(bin).observe(viewLifecycleOwner) { binInfo ->
            binding.tvSchemeNetwork.text = binInfo.scheme
        }
    }*/

    /*private fun setClick() {
        binding.tvUrl.setOnClickListener {
            val url = "http://" + binding.tvUrl.text
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}