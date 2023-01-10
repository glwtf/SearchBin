package com.example.searchbin.domain

class GetSearchedBinListUseCase (private val repository: SearchBinRepository) {

    operator fun invoke() = repository.getSearchedBinList()
}