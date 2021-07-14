package com.sandyara.aula21.domain

import com.sandyara.aula21.data.repository.MarvelRepository

class FetchCharactersUseCase(
        private val repository: MarvelRepository = MarvelRepository()
) {
    fun execute() = repository.fetchCharactersList()
}