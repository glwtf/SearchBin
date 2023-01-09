package com.example.searchbin.domain

class GetSearchedBinListUseCase (private val repository: SearchBinRepository) {

    operator fun invoke(itemId : Int) = repository.getSearchedBinList()
}