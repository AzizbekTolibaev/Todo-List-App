package com.example.todolistapp.di

import com.example.todolistapp.app.App
import com.example.todolistapp.data.dao.database.TasksDatabase
import org.koin.dsl.module

val networkModule = module {
    single {
        TasksDatabase.getInstance(App.instance).getTaskDao()
    }

    single {
        TasksDatabase.getInstance(App.instance).getCompletedTaskDao()
    }
}