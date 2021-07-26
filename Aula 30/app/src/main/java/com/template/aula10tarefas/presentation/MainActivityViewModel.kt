package com.template.aula10tarefas.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.template.aula10tarefas.model.Tarefa
import com.template.aula10tarefas.repository.TarefasLocalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(private val tarefasLocalRepository:TarefasLocalRepository=TarefasLocalRepository(),
                            application: Application): AndroidViewModel(application) {
    private val tarefasLiveData = MutableLiveData<List<Tarefa>>()
    val tarefasObserver: LiveData<List<Tarefa>> get()=tarefasLiveData

    val contexto = getApplication<Application>().applicationContext

    fun getTarefas(){
        var response: List<Tarefa>? = null

        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            response = tarefasLocalRepository.getTarefas(contexto)
            tarefasLiveData.postValue(response)
        }
    }

    fun addTarefa(tarefa: Tarefa){
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            tarefasLocalRepository.addTarefa(contexto, tarefa)
            getTarefas()
        }
    }

    fun deleteTarefa(tarefa: Tarefa){
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            tarefasLocalRepository.deleteTarefa(contexto, tarefa)
            getTarefas()
        }
    }
}