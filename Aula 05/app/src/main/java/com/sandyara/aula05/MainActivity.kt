package com.sandyara.aula05

import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    //DECLARAR VARIÁVEIS E COMPONENTES
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numeros = listOf(1, 2, 3, 4, 5)

        //INICIALIZAR O COMPONENTE
        resultado = findViewById(R.id.resultado)
        var soma = 0

        for(numeroIndividual in numeros){
            //soma = soma + numeroIndividual
                //soma = 0 + 1
                    // soma = 1 + 2
            soma += numeroIndividual
        }

        resultado.text = "O resultado é " + soma

        //range
        for(contador in 1..3){
            if(contador % 2 == 0){
                //Toast.makeText(this, "Esse número é par!", Toast.LENGTH_LONG).show()
            }
        }

        for(i in 10 downTo 1){
            for(j in 1..10){
                if(i == j){
                    //Exibir mensagem
                }
            }
        }

        for(i in 1..11 step 2){

        }

        var x = 0

        var nome : String? = null
        while (nome == null){
            nome = "Sandy"
        }

        do {
            //
            x = 1
        } while (x == 0)



        /*
        * COMPARANDO COM JAVA
        * i = i + 1
        * for(int i = 0; i <= 10; i++){
        *
        *
        * }
        *
        *
        * */

        resultado.setOnClickListener {
            calcular(2)
        }
    }

    fun calcular(numero: Int){
        //Função qualquer
    }

//    fun getDateFromDatePicker(datePicker: DatePicker): Date? {
//        val day = datePicker.dayOfMonth
//        val month = datePicker.month
//        val year = datePicker.year
//        val calendar: Calendar = Calendar.getInstance()
//        calendar.set(year, month, day)
//        return calendar.getTime()
//    }

}