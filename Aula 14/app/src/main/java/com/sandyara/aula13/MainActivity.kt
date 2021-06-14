package com.sandyara.aula13

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rachel = Aluna(nome = "Rachel Nunes", idade = 20)
        val mari = Bolsista(nomeBolsista = "Mariana Nunes", idadeBolsista = 20, desconto = 4000.00)

        //INTENT EXPLÍCITA
        navegar.setOnClickListener{
            //contexto, destino
            //Class x KClass
            //Class -> Classe Java já gerada (.java)
            //KClass -> Classe Kotlin (.kt)

            //meu envelope
            val intent = Intent(this, SecondActivity::class.java)

            //minha carta
            intent.putExtra(NOME_KEY, "Sandy")
            intent.putExtra("IDADE", 21)

            val listaAlunas = arrayOf(
                Aluna(nome = "Rachel Nunes", idade = 20),
                Aluna(nome = "Rachel Nunes", idade = 20)
            )

            intent.putExtra(STUDENT_KEY, listaAlunas)
            intent.putExtra(STUDENT_KEY, rachel)
            intent.putExtra(STUDENT_KEY, mari)

            startActivity(intent)
        }

        tirarFoto.setOnClickListener {
            //INTENT IMPLÍCITA
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            //VERIFICAR SE A ACTIVITY EXISTE DE FATO PARA ESSA AÇÃO
            if(intent.resolveActivity(packageManager) != null){
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }
        }
        //val variavel = Objeto().atributo
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK){
            val fotoTirada = data?.extras?.get("data") as Bitmap?
            fotoTirada?.let{
                foto.setImageBitmap(it)
            }
        }
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
        val CAMERA_REQUEST_CODE = 14523
        val NOME_KEY = "XUXAMENEGHEL"
        val STUDENT_KEY = "ALUNA"
        val lista =  mutableListOf<String>("a", "b", "c")
    }
}