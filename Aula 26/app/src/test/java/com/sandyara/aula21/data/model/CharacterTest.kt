package com.sandyara.aula21.data.model

import org.junit.Assert
import org.junit.Test


class CharacterTest {

    /*
    * Dado que há um personagem, quando for exibido seus dados em tela, então retornar seu nome e descrição
    */

    @Test
    fun `exibe nome e descricao de um personagem`(){
        //ARRANGE
        val personagem = Character(1,
            "Spiderman",
            "Algo",
            Thumbnail("caminhoImagem", "jpg"))

        //ACT
        val resposta = personagem.getCharacterInfo()

        //ASSERT
        Assert.assertEquals("Nome: Spiderman Descrição: Algo", resposta)
    }
}