package com.example.todoapp

import android.content.Context
import androidx.room.Room
import com.example.todoapp.db.AppDataBase
import com.example.todoapp.repository.ToDoRepository

object Dependencies {
    private lateinit var applicationContext: Context

fun init(context: Context) {
    applicationContext = context
}

private val appDatabase: AppDataBase by lazy {
    Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database.db")
        .build()
}

val toDoRepository: ToDoRepository by lazy { ToDoRepository(appDatabase.getToDoDao()) }
}