package com.example.searchbin.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.searchbin.data.SearchBinRepositoryImpl
import com.example.searchbin.domain.BinInfo
import com.example.searchbin.domain.LoadBinInfoUseCase
import kotlinx.coroutines.launch

class SearchBinInfoViewModel(application: Application) : AndroidViewModel(application)  {

    private val repository = SearchBinRepositoryImpl(application)
    private val loadBinInfoUseCase = LoadBinInfoUseCase(repository)

    fun searchBinInfo(bin : String) : LiveData<BinInfo> {
        val result = MutableLiveData<BinInfo>()
        viewModelScope.launch {
            val binInfo = loadBinInfoUseCase(bin)
            result.value = binInfo
        }
        return result
    }
}