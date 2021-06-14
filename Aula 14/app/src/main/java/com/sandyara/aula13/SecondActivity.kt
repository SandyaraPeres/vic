package com.sandyara.aula13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nomeRecebido = intent.getStringExtra(MainActivity.NOME_KEY)
        val idadeRecebida = intent.getIntExtra("IDADE", 0)

        val alunaRecebida = intent.extras?.get(MainActivity.STUDENT_KEY) as Aluna

        Toast.makeText(this,
                "Nome: $nomeRecebido Idade: $idadeRecebida" +
                "Aluna: ${alunaRecebida.getIsLindaPraCaramba()}",
                Toast.LENGTH_SHORT).show()

        //val a = MainActivity.lista.add()
    }
}