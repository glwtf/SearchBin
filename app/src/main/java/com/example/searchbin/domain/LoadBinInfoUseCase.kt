package com.example.searchbin.domain

class LoadBinInfoUseCase (private val repository: SearchBinRepository) {

    suspend operator fun invoke(bin : String) = repository.loadBinInfo(bin)
}