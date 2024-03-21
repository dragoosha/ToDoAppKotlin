package com.example.todoapp.db.ToDoDatabase

import androidx.room.Insert

data class TodoInfoTuple(
    val id : Long,
    val textNote : String,
    val statusNote : Boolean
) {
    @Insert(entity = ToDoEntity::class)
    fun insertNewStatisticData(toDoData : ToDoEntity) {}
}