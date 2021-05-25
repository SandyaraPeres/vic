package com.sandyara.aula07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edtNomeUsuarioCadastro : EditText
    private lateinit var edtCredencialUsuarioCadastro : EditText
    private lateinit var rdgSetorCadastro : RadioGroup
    private lateinit var btnCadastrar : Button
    private lateinit var edtPesquisar : EditText
    private lateinit var btnPesquisar : Button

    private var funcionarios : MutableList<Funcionario> = mutableListOf()

    //STANDBY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
    }
    
    private fun bindViews(){
        edtNomeUsuarioCadastro = findViewById(R.id.edtNome)
        edtCredencialUsuarioCadastro = findViewById(R.id.edtMatricula)
        btnCadastrar = findViewById(R.id.btnCadastrar)

        edtPesquisar = findViewById(R.id.edtPesquisa)
        rdgSetorCadastro = findViewById(R.id.rdgSetor)
        btnPesquisar = findViewById(R.id.btnPesquisar)

        btnCadastrar.setOnClickListener {
            val nomeDigitado = edtNomeUsuarioCadastro.text.toString()
            val credencialDigitada = edtCredencialUsuarioCadastro.text.toString()
            val setorSelecionado = rdgSetorCadastro.checkedRadioButtonId

            registrarFuncionario(nomeDigitado, credencialDigitada, setorSelecionado)

//            val sandy = Funcionario("Sandy", "2345678", 2)
//            Toast.makeText(this, "Boas vindas, ${sandy.nome}", Toast.LENGTH_LONG).show()
//            sandy.setor = 3
//
//            val monique = Funcionario("Monique", "1234567", 3)
        }

        btnPesquisar.setOnClickListener {
            val pesquisa = edtPesquisar.text.toString()

            //xuxa == contador (do for)
            val resultado = funcionarios.find { xuxa ->
                xuxa.getCredencial() == pesquisa
            }

//            val resultadoPesquisa = funcionarios.contains{ angelica ->
//                angelica.setor == pesquisa
//            }

//            val teste = funcionarios.filter { funcionario ->
//
//                funcionario.getCredencial().length > 2
//            }

            if (resultado != null) {
                Toast.makeText(this,
                        resultado.exibirRegistro(),
                        Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,
                        "Não foi possível encontrar um funcionário",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registrarFuncionario(nome: String, credencial: String, setor: Int){
        funcionarios.add(
                Funcionario(credencial = credencial, nome = nome, setor = setor)
        )

        //Também pode construir o objeto direto na ordem estabelecida no construtor! :)
        //Funcionario(nome, credencial, setor)

        Toast.makeText(this,
                funcionarios.last().exibirRegistro(),
                Toast.LENGTH_SHORT).show()
    }
}