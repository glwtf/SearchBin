package com.example.searchbin.domain

class AddSearchedBinUseCase (private val repository: SearchBinRepository) {

    suspend operator fun invoke(binInfo: BinInfo)
        = repository.addSearchedBin(binInfo)
}