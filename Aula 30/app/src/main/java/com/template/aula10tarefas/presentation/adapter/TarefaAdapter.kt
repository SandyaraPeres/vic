package com.template.aula10tarefas.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.template.aula10tarefas.R
import com.template.aula10tarefas.model.Tarefa

class TarefaAdapter(var listaTarefa: List<Tarefa>, var listener: TarefaAdapterListener):RecyclerView.Adapter<TarefaAdapter.ItemViewHolder>() {

    // Responsável por encontrar os componentes dentro do layout (item_usuario) e indicar que o
    //  layout será replicado na Recycler View
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtTarefa: TextView = view.findViewById(R.id.txtTarefa)
        val btnExcluir: ImageButton = view.findViewById(R.id.btnExcluir)
    }

    // Responsável por inflar (fazer aparecer) o layout por exemplo na activity ou fragment ou dialog (tudo que extends View Group)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return ItemViewHolder(view)
    }

    // Vincula os componentes do layout (item_usuario) a um dado/propriedade/atributo da lista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.txtTarefa.text = listaTarefa[position].nome

        // Implementando o "click" do CardView para retornar um Toast como mensagem
        holder.btnExcluir.setOnClickListener(){
            listener.excluirTarefa(listaTarefa[position])
        }
    }

    // Indica quantos registros/itens a lista possui
    override fun getItemCount(): Int {
        return listaTarefa.size
    }

    fun refreshListTarefa(listaAtualizada: List<Tarefa>){
        listaTarefa = listaAtualizada
        notifyDataSetChanged()
    }
}
