package com.sandyara.aula21.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.sandyara.aula21.R

class FormActivity : AppCompatActivity() {

    private lateinit var nome: EditText
    private lateinit var msg: EditText
    private lateinit var exibir: Button
    private var nomeUsuario = ""
    private var mensagemUsuario = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        nome = findViewById(R.id.edtNome)
        msg = findViewById(R.id.edtMessage)
        exibir = findViewById(R.id.btnExibir)

        exibir.setOnClickListener {
            nomeUsuario = nome.text.toString()
            mensagemUsuario = msg.text.toString()
            if(validaCampos()){
                exibirMensagem()
            }
        }

    }

    fun exibirMensagem(){
        Toast.makeText(this, "$nomeUsuario, você sabia que $mensagemUsuario", Toast.LENGTH_SHORT).show()
    }

    fun validaCampos() : Boolean = nomeUsuario.isNotEmpty() && mensagemUsuario.isNotEmpty()

}