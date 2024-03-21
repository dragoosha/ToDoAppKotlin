package com.example.todoapp.db.ToDoDatabase

class ToDo(
    val textNote : String,
    val statusNote : Boolean
) {
    fun toToDoDbEntity() : ToDoEntity = ToDoEntity(
        id = 0,
        textNote = textNote,
        statusNote = statusNote
    )
}
