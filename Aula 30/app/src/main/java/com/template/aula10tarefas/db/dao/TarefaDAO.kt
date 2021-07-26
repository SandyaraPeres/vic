package com.template.aula10tarefas.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.template.aula10tarefas.model.Tarefa

@Dao
interface TarefaDAO {
    @Query("SELECT * FROM TB_TAREFA")
    fun getTarefas(): List<Tarefa>

    @Insert
    fun addTarefas(t: Tarefa)

    @Delete
    fun deleteTarefa(t: Tarefa)
}
