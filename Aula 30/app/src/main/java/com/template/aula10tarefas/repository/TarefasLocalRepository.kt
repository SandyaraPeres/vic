package com.template.aula10tarefas.repository

import android.content.Context
import com.template.aula10tarefas.db.AppDatabase
import com.template.aula10tarefas.db.DatabaseBuilder
import com.template.aula10tarefas.model.Tarefa

class TarefasLocalRepository() {
    private var db: AppDatabase?=null

    suspend fun getTarefas(contexto: Context): List<Tarefa>?{
        var response: List<Tarefa>?=null

        // Cria ou recupera o BD da aplicação
        db = DatabaseBuilder.getAppDatabase(contexto)

        // Recupera ações/métodos de acesso a dados da entidade (tabela)
        val tarefaDAO = db?.tarefaDao()

        // A partir do DAO executa uma ação escolhida (SELECT)
        response = tarefaDAO?.getTarefas()

        return response
    }

    suspend fun addTarefa(contexto: Context, tarefa: Tarefa){
        // Cria ou recupera o BD da aplicação
        db = DatabaseBuilder.getAppDatabase(contexto)

        // A partir do DAO executa uma ação escolhida (INSERT)
        db?.tarefaDao()?.addTarefas(tarefa)
    }

    suspend fun deleteTarefa(contexto: Context, tarefa: Tarefa){
        // Cria ou recupera o BD da aplicação
        db = DatabaseBuilder.getAppDatabase(contexto)

        // A partir do DAO executa uma ação escolhida (DELETE)
        db?.tarefaDao()?.deleteTarefa(tarefa)
    }
}