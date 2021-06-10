package com.sandyara.aula11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textview = findViewById<TextView>(R.id.txtExemplo)

        val a = "aaa"
        val b = 12

        val texto = getString(R.string.teste, a, b)
        textview.text = texto

        Toast.makeText(this, getString(R.string.boasvindas), Toast.LENGTH_SHORT).show()

//        textview.setOnClickListener {
//            new OnClickListener () {
//                @Override
//                public void onClick(View v) {
//                    //seu clique
//                }
//            }
//        }

//        textview.setOnClickListener(object : View.OnClickListener){
//            override fun onClick(View v){
//                //
//            }
//        }

        textview.setOnClickListener(){
            v -> //alguma acao
        }

        textview.setOnClickListener{
            v -> //alguma acao
        }

        textview.setOnClickListener {  }

    }
}