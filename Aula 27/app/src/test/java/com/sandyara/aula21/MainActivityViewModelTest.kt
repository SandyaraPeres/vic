package com.sandyara.aula21

import com.sandyara.aula21.presentation.MainActivityViewModel
import org.junit.Assert
import org.junit.Test

class MainActivityViewModelTest {
    /*
    * 1. Exibe uma lista de personagens
    * 2. Retorna uma mensagem de erro da API
    * 3. Retorna uma mensagem de erro na requisição
    * 4. Retorna uma mensagem padrão quando vier nenhum personagem
    * */

    @Test
    fun `exibe lista de personagens`(){

        //PROBLEMAS ATÉ ENTÃO
        //1. lista EXTENSA para criarmos como resultado esperado
        //2. depender da chamada de API
        //3. depender da visualização dos dados no livedata

        //Bibliotecas que SIMULAM comportamentos de arquitetura
        //SIMULAR -> MOCK
        //Injeção de dependências

        //ACT
        //val resultado = MainActivityViewModel().getCharacters()

        //ASSERT

        //Assert.assertEquals("")
    }

    @Test
    fun `retorna erro de API ao tentar listar personagens`(){

    }

    @Test
    fun `retorna erro de requisição ao tentar listar personagens`(){

    }


    @Test
    fun `retorna mensagem padrão ao retornar uma lista de personagens vazia`(){

    }
}