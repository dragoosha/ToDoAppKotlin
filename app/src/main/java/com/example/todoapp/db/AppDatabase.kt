package com.example.todoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.db.ToDoDatabase.ToDoDao
import com.example.todoapp.db.ToDoDatabase.ToDoEntity

@Database(
    version = 1,
    entities = [
        ToDoEntity::class
    ]
)
abstract class AppDataBase : RoomDatabase(){

    abstract fun getToDoDao() : ToDoDao
}