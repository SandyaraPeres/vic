package com.sandyara.aula18

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class First : Fragment(){

    lateinit var ADAPTER2 : Adapter
    lateinit var ADAPTER : Adapter2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.recyclerview1)
        ADAPTER2 = Adapter(listOf("Nome: Sandy, Idade: 21", "Nome: Joana, Idade: 23"))
        rv.adapter = ADAPTER2
        rv.layoutManager = LinearLayoutManager(requireActivity())
    }
}