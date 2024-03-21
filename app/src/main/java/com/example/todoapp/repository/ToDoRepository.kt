package com.example.todoapp.repository

import com.example.todoapp.db.ToDoDatabase.ToDoDao
import com.example.todoapp.db.ToDoDatabase.ToDoEntity
import com.example.todoapp.db.ToDoDatabase.TodoInfoTuple
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ToDoRepository (
    private val toDoDao: ToDoDao
) {

    suspend fun insertNewToDoNote(toDoEntity: ToDoEntity) {
        withContext(Dispatchers.IO) {
            toDoDao.insertNewToDoNote(toDoEntity)
        }
    }

    suspend fun getAllData(): Flow<List<TodoInfoTuple>> {
        return withContext(Dispatchers.IO) {
            return@withContext toDoDao.getAllData()
        }
    }

    suspend fun remoteData(id: Long) {
        withContext(Dispatchers.IO) {
            toDoDao.remoteData(id)
        }
    }
}