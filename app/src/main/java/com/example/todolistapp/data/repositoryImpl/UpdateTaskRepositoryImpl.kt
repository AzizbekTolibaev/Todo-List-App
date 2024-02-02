package com.example.todolistapp.data.repositoryImpl

import com.example.todolistapp.data.TaskData
import com.example.todolistapp.data.dao.TasksDao
import com.example.todolistapp.domain.repository.UpdateTaskRepository

class UpdateTaskRepositoryImpl(private val dao: TasksDao): UpdateTaskRepository {

    override suspend fun updateTask(task: TaskData) = dao.updateTask(task)
}