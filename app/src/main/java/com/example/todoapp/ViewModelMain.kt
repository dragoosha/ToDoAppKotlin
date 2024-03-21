package com.example.todoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.db.ToDoDatabase.ToDo
import com.example.todoapp.repository.ToDoRepository
import kotlinx.coroutines.launch

class ViewModelMain(private val toDoRepository: ToDoRepository ) : ViewModel() {
    private val currentStatus : Boolean = false

    fun insertNewToDoNote (currentNote : String) {
        viewModelScope.launch {
            val newToDo = ToDo(currentNote, currentStatus)
            toDoRepository.insertNewToDoNote(newToDo.toToDoDbEntity())
        }
    }
}