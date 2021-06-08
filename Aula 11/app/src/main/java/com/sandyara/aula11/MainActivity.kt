package com.sandyara.aula11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textview = findViewById<TextView>(R.id.txtExemplo)

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