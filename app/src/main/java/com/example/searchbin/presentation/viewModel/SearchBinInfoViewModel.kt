package com.example.searchbin.presentation.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.searchbin.R
import com.example.searchbin.data.SearchBinRepositoryImpl
import com.example.searchbin.domain.BinInfo
import com.example.searchbin.domain.LoadBinInfoUseCase
import kotlinx.coroutines.launch

class SearchBinInfoViewModel(application: Application) : AndroidViewModel(application)  {

    private val context = application
    private val repository = SearchBinRepositoryImpl(context)
    private val loadBinInfoUseCase = LoadBinInfoUseCase(repository)

    private val _errorInputBin = MutableLiveData<Boolean>()
    val errorInputBin : LiveData<Boolean>
        get() = _errorInputBin

    fun searchBinInfo(bin : String) : LiveData<BinInfo> {
        val result = MutableLiveData<BinInfo>()
        val binIsValid = validateBin(bin)
        if (binIsValid) {
            viewModelScope.launch {
                val binInfo = loadBinInfoUseCase(bin)
                checkRequest(binInfo)
                result.value = binInfo
            }
        }
        return result
    }

    private fun validateBin(bin : String) : Boolean {
        var ret = true
        if (!isNumeric(bin) || (bin.length < 6 || bin.length  > 8)) {
            _errorInputBin.value = true
            ret = false
        }
        return ret
    }

    private fun isNumeric(toCheck : String) = toCheck.all {
        it.isDigit()
    }

    fun resetErrorInputBin() {
        _errorInputBin.value = false
    }

    private fun checkRequest(binInfo: BinInfo) {
        if (binInfo.scheme == NOT_FOUND)
            Toast.makeText(context, R.string.bin_not_found, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val NOT_FOUND = "Not found/"
    }
}