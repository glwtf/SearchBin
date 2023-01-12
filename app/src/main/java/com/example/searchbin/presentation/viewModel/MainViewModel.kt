package com.example.searchbin.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.searchbin.data.SearchBinRepositoryImpl
import com.example.searchbin.domain.GetSearchedBinListUseCase

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SearchBinRepositoryImpl(application)

    private val getSearchedBinListUseCase = GetSearchedBinListUseCase(repository)

    val ldBinInfoList = getSearchedBinListUseCase()
}