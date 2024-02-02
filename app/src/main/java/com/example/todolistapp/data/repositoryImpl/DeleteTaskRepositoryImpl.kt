package com.example.todolistapp.data.repositoryImpl

import com.example.todolistapp.data.TaskData
import com.example.todolistapp.data.dao.TasksDao
import com.example.todolistapp.domain.repository.DeleteTaskRepository

class DeleteTaskRepositoryImpl(private val dao: TasksDao): DeleteTaskRepository {

    override suspend fun deleteTask(task: TaskData) = dao.deleteTask(task)
}