package com.sandyara.aula13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val variavel = Objeto().atributo
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d("MeuAplicativo", "Ciclo de vida onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MeuAplicativo", "Ciclo de vida onResumo")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MeuAplicativo", "Ciclo de vida onPause")
        Toast.makeText(this, "Lembre de preencher os dados restantes mais tarde!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MeuAplicativo", "Ciclo de vida onDestroy")
    }

    companion object{
        val lista =  mutableListOf<String>("a", "b", "c")
    }
}