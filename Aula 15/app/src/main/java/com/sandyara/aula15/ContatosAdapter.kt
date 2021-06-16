package com.sandyara.aula15

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//Classe de Adapter: vínculo entre dataset e viewholder (item)
class ContatosAdapter(val dataSet: MutableList<Contato>) : RecyclerView.Adapter<> {

    //Class de ViewHolder: vínculo de atributos xml <> código
    class ContatosViewHolder() : RecyclerView.ViewHolder(){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ??? {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ???, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}