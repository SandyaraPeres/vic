package com.sandyara.aula15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class HeaderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_header, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val texto = view.findViewById<TextView>(R.id.textoQualquer)

        texto.setOnClickListener {
            Toast.makeText(requireActivity(), "Mensagem", Toast.LENGTH_SHORT).show()
            //NAO FUNFA :( FRAGMENT N SABE DO CONTEXTO DA APLICAÇÃO
        // Toast.makeText(this, "Mensagem", Toast.LENGTH_SHORT).show()
        }
    }
}