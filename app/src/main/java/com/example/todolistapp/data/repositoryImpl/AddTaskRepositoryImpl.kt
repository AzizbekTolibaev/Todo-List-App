package com.example.todolistapp.data.repositoryImpl

import com.example.todolistapp.data.TaskData
import com.example.todolistapp.data.dao.TasksDao
import com.example.todolistapp.domain.repository.AddTaskRepository

class AddTaskRepositoryImpl(private val dao: TasksDao): AddTaskRepository {
    override suspend fun addTask(task: TaskData) {
        dao.addTask(task)
    }
}