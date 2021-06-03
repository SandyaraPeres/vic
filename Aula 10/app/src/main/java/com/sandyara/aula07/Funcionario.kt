package com.sandyara.aula07

open class Funcionario(open val nome: String,
                       private var credencial: String,
                       open var setor: Setor? = null){

//    constructor(nome: String): this(nome)


    //OPEN == PROTECTED
    open fun getCredencial() : String = credencial

    open fun setCredencial(credencialInserida : String){
        credencial = credencialInserida
    }

    open fun exibirRegistro() : String{
        return "$nome - $credencial do setor ${setor?.descricao}"
    }
}

/*
 * JVM -> funcionario.credencial =
 * setCredencial
 */

//nome, credencial, setor
//
//class Funcionario{
//    String nome;
//    String credencial;
//    Int setor;
//
//    Funcionario(String nomeDigitado, String credencialDigitada, Int setorDigitado){
//        nome = nomeDigitado;
//        credencial = credencialDigitada;
//        setor = setorDigitado;
//    }
//
//    public String getNome(){
//        return nome;
//    }
//
//    function setSetor(Int novoSetor){
//        setor = novoSetor
//    }
//}
//
//xuxa.setOnClickListener{
//    Funcionario funcionario1 = new Funcionario("WILCILENE", "12345", 1)
//    String nome = funcionario1.getNome()
//}