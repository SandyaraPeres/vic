package com.template.aula10tarefas.presentation.adapter

import com.template.aula10tarefas.model.Tarefa

interface TarefaAdapterListener {
    fun excluirTarefa(tarefa: Tarefa)
}
