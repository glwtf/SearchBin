package com.example.searchbin.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.searchbin.data.SearchBinRepositoryImpl
import com.example.searchbin.domain.BinInfo
import com.example.searchbin.domain.GetSearchedBinItemUseCase
import kotlinx.coroutines.launch

class BinInfoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SearchBinRepositoryImpl(application)
    private val getSearchedBinItemUseCase = GetSearchedBinItemUseCase(repository)

    fun getBinInfoItem(bin : Int) : LiveData<BinInfo> {
        val result = MutableLiveData<BinInfo>()
        viewModelScope.launch {
            val binInfo = getSearchedBinItemUseCase(bin)
            result.value = binInfo
        }
        return result
    }
}