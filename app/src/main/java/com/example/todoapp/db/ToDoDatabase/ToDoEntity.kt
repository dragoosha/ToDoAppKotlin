package com.example.todoapp.db.ToDoDatabase

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "todo_database",
    indices = [Index("id")]
)
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true) val id : Long,
    val textNote : String,
    val statusNote : Boolean
)