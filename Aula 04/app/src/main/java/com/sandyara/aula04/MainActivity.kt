package com.sandyara.aula04

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var adicionarAluno : Button
    lateinit var nomeAluno : EditText
    lateinit var listaAlunos : TextView
    //lateinit var alunosCadastrados : MutableList<String>
    val alunosCadastrados = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adicionarAluno = findViewById(R.id.btnAdd)
        nomeAluno = findViewById(R.id.edtAluno)
        listaAlunos = findViewById(R.id.txtResultado)

        adicionarAluno.setOnClickListener {
            val nome = nomeAluno.text.toString()

            if(nome.isNotEmpty()){
                cadastrarAluno(nome)
            } else {
                nomeAluno.error = "Digite um nome válido!"
            }
        }

    }

    fun cadastrarAluno(nome: String){

        //listOf, setOf, mapOf = tipos IMUTÁVEIS, não posso incluir, nem fazer nada
        //mutableListOf, mutableSetOf, mutableMapOf = tipos MUTÁVEIS, posso add, remover, o que eu quiser

        //COLLECTIONS DO KOTLIN
        //list = é uma coleção que permite duplicação
        val alunosCadastradosList = mutableListOf("Ana", "Ingrid", "Mirian", "Ana")

        //set = é uma coleção que NÃO permite valores duplicados
        val alunosCadastradosSet = setOf("Ana", "Mariana", "Ludmilla", "Ana")

        listaAlunos.visibility = View.VISIBLE

//        var mensagem = "Lista:"
//
//        for(aluno in alunosCadastradosList){
//            mensagem += "Nome: $aluno \n"
//        }
//
//        mensagem+= "Set"
//
//        for(aluno in alunosCadastradosSet){
//            mensagem += "Nome: $aluno \n"
//        }

        //map

//        var mensagem = ""
//
//        val alunosCadastradosMap = mapOf<Int, String>(1 to "Ana", 2 to "Ingrid", 3 to "Daniela")
//
//
//        for(xuxa in alunosCadastradosMap){
//            mensagem += "Matrícula: ${xuxa.key} Nome: ${xuxa.value} \n"
//        }
//
//        listaAlunos.text = mensagem

        val listaNumerosLoteria = mutableListOf(3, 5, 18, 23, 48, 54)
        listaNumerosLoteria.clear()
        listaNumerosLoteria.addAll(listOf(8, 9, 10, 11, 12, 13, 14))


        listaNumerosLoteria.filter { it == 18 }
        listaAlunos.text = listaNumerosLoteria.toString()

        var exibirAlunos = ""

        alunosCadastrados.add(nome)

        for(angelica in alunosCadastrados){
            exibirAlunos+= "Nome: $angelica \n"
        }

        //listaAlunos.text = exibirAlunos


    }
}