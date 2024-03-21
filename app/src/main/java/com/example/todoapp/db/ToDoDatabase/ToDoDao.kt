package com.example.todoapp.db.ToDoDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Insert(entity = ToDoEntity::class)
    fun insertNewToDoNote (toDoNote : ToDoEntity)

    @Query("SELECT todo_database.id, textNote, statusNote FROM todo_database\n")
    fun getAllData() : Flow<List<TodoInfoTuple>>

    @Query("DELETE FROM todo_database WHERE id = :noteId")
    fun remoteData(noteId: Long)


}