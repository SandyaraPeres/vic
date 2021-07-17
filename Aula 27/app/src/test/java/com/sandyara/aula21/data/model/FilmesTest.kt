package com.sandyara.aula21.data.model

import org.junit.Assert.assertEquals
import org.junit.Test

/*
* 1. Dado que o usuário queira mais informações de um filme
* Quando ele tocar para exibir um filme que goste
* Então deve ser redirecionado para uma tela com os dados do filme
*
* 2. Dado que o usuário goste MUITO de um filme
* Quando ele tocar no coraçãozinho
* Então esse filme será adicionado as favoritos
*
* */
class FilmesTest {
    @Test
    fun `exibir dados de um filme`(){
        //ARRANGE
        val filme = Movie(
            name = "Cruella",
            description = "Conta a história da vilã ic...Disney"
        )

        //ACT
        val resultado = filme.getDataInfo()

        //ASSERT
        assertEquals("Cruella\nConta a história da vilã ic...Disney", resultado)
    }
}