package com.sandyara.aula07

data class Funcionario(private val nome: String,
                       private val credencial: String,
                       private var setor: Setor){

    fun getCredencial() : String = credencial

    fun exibirRegistro() : String{
        return "$nome - $credencial do setor ${setor.descricao}"
    }
}

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