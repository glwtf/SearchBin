package com.example.searchbin.domain

class GetSearchedBinItemUseCase (private val repository: SearchBinRepository) {

    suspend operator fun invoke(bin: Int) = repository.getSearchedBinItem(bin)
}