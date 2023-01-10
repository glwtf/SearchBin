package com.example.searchbin.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchbin.data.SearchBinRepositoryImpl
import com.example.searchbin.domain.LoadBinInfoUseCase
import kotlinx.coroutines.launch

class SearchBinInfoViewModel(application: Application) : AndroidViewModel(application)  {

    private val repository = SearchBinRepositoryImpl(application)

    //private val getSearchedBinItemUseCase = GetSearchedBinItemUseCase(repository)
    private val loadBinInfoUseCase = LoadBinInfoUseCase(repository)

    fun searchBinInfo(bin : String) {
        viewModelScope.launch {
            val validSearch = loadBinInfoUseCase(bin)
            if (validSearch) {
                //TODO: add check success search
            }
        }
    }
}