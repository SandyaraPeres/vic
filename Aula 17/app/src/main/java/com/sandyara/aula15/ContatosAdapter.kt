package com.sandyara.aula15

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//Classe de Adapter: vínculo entre dataset e viewholder (item)
class ContatosAdapter(val listener: ItemListener? = null,
                      var dataSet: MutableList<Contato>) : RecyclerView.Adapter<ContatosAdapter.ContatosViewHolder>() {

    //=====VIEWHOLDER======
    //Class de ViewHolder: vínculo de atributos xml <> código;
    // referência entre os componentes e o código (ex. findViewById)
    class ContatosViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nome = view.findViewById<TextView>(R.id.itemNome)
        val descricao = view.findViewById<TextView>(R.id.itemDescricao)
    }

    //========================

    //====ADAPTER====

    //Ciclo de vida vulgo método que cria o viewholder
    //parent = componente mãe que vai chamar esse meu adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosViewHolder {
        val instanciaView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_contato, parent, false)
        return ContatosViewHolder(instanciaView)
    }

    //Vínculo entre dataset x item (layout)
    //Substituir os itens do layout pelos itens do meu dataset
    override fun onBindViewHolder(holder: ContatosViewHolder, position: Int) {
        holder.nome.text = dataSet[position].nome
        holder.descricao.text = dataSet[position].descricao
        holder.itemView.setOnClickListener {
            listener?.let{
                it.setOnDeleteListener()
                //CÓDIGO EXCLUIR, REMOVE AT()
            }
            //Toast.makeText(context, "O item está na posicao $position", Toast.LENGTH_SHORT).show()
        }
    }

    //Tamanho do dataset / tamanho dos itens da lista
    override fun getItemCount(): Int = dataSet.size

    fun atualizarLista(listaFiltrada: MutableList<Contato>){
        dataSet = listaFiltrada
        notifyDataSetChanged()
    }
}