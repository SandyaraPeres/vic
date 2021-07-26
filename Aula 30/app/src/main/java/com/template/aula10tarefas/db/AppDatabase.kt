package com.template.aula10tarefas.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.template.aula10tarefas.db.dao.TarefaDAO
import com.template.aula10tarefas.model.Tarefa

@Database(entities = arrayOf(Tarefa::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun tarefaDao(): TarefaDAO

    // Implementar aqui todos os DAOs que o App tiver daqui pra baixo...
}
