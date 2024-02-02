package com.example.todolistapp.data.repositoryImpl

import com.example.todolistapp.data.TaskData
import com.example.todolistapp.data.dao.TasksDao
import com.example.todolistapp.domain.repository.AllTasksRepository

class AllTasksRepositoryImpl(private val dao: TasksDao): AllTasksRepository {

    override suspend fun getAllTasks(): List<TaskData> {
        return dao.getAllTasks()
    }
}