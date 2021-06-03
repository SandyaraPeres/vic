package com.sandyara.aula07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var edtNomeUsuarioCadastro : EditText
    private lateinit var edtCredencialUsuarioCadastro : EditText
    private lateinit var rdgSetorCadastro : RadioGroup
    private lateinit var btnCadastrar : Button
    private lateinit var edtPesquisar : EditText
    private lateinit var btnPesquisar : Button

    private var setorSelected: Setor? = null

    private var funcionarios : MutableList<Funcionario> = mutableListOf()

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
            //val setorSelecionado = rdgSetorCadastro.checkedRadioButtonId

            setorSelected?.let{
//                val abc = Setor.TECNOLOGIA
//                abc.id
//                abc.descricao

                //WRAP = envolver em um if( VARIAVEL != null)
                //UNWRAP = remover verificação
                registrarFuncionario(nomeDigitado, credencialDigitada, it)
            }

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

    private fun registrarFuncionario(nome: String, credencial: String, setor: Setor){
        funcionarios.add(
                Funcionario(credencial = credencial, nome = nome)
        )

        val gerenteA = Gerente("Dani",
                "XPTO123",
                Setor.TECNOLOGIA,
        5)

        //REFERENTE AO GERENTE
        gerenteA.darBronca()

        //REFERENTE A FUNCIONARIO
        gerenteA.exibirRegistro()
        gerenteA.getCredencial()

        gerenteA.setCredencial("ABCD1234")

        gerenteA.numeroDeTimesResponsavel
        gerenteA.nome

        //Também pode construir o objeto direto na ordem estabelecida no construtor! :)
        //Funcionario(nome, credencial, setor)

        Toast.makeText(this,
                funcionarios.last().exibirRegistro(),
                Toast.LENGTH_SHORT).show()
    }

    private fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {

            //Caso especial pra Radio B(urro)utton
            val foiChecado = view.isChecked

            when (view.id) {
                R.id.rdTech ->
                    if (foiChecado) {
                        setorSelected = Setor.TECNOLOGIA
                    }
                R.id.rdRH -> {
                    if (foiChecado) {
                        setorSelected = Setor.RECURSOS_HUMANOS
                    }
                }
                R.id.rdComercial ->
                    if (foiChecado) {
                        setorSelected = Setor.COMERCIAL
                    }
            }

        }
        //when(clicado){..}
    }

}