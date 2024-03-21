package com.example.todoapp.NoteUi

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.db.ToDoDatabase.TodoInfoTuple
import com.example.todoapp.repository.ToDoRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ViewModelNote(private val toDoRepository: ToDoRepository) : ViewModel() {
    private val _notes = MutableLiveData<List<TodoInfoTuple>>()
    val notes: LiveData<List<TodoInfoTuple>> = _notes

    init {
        getAllNotes()
    }

    fun remoteData(id: Long) {
        viewModelScope.launch {
            toDoRepository.remoteData(id)
            getAllNotes()
        }
    }

    private fun getAllNotes() {
        viewModelScope.launch {
            toDoRepository.getAllData().collect {
                _notes.value = it
            }
        }
    }
}