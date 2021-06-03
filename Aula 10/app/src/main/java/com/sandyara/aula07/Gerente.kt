package com.sandyara.aula07

class Gerente(nomeGerente : String,
              credencialGerente: String,
              setorGerente: Setor,
              val numeroDeTimesResponsavel: Int) :
        Funcionario(nomeGerente,
                credencialGerente,
                setorGerente) {

    fun darBronca() : String = "Levanta Gay Bora Trabalhar"

    //eu acho que herança é reutilização e polimorfismo é reciclagem. Tipo isso kkk by Samyra Rocha
    override fun exibirRegistro() : String{
        return "$nome - $ do setor ${setor?.descricao} " +
                "que cuida de $numeroDeTimesResponsavel times"
    }
}

/*
*
* public class Gerente extends Funcionario...
*
*  function Gerente(..)
* { super(...)}
*
* */