package com.sandyara.aula21

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharactersAdapter(var dataset: MutableList<Character> = mutableListOf()) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    inner class CharactersViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder =
        CharactersViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.name.text = dataset[position].name
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}