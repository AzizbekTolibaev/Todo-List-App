package com.example.todolistapp.data.repositoryImpl

import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.data.dao.CompletedTaskDao
import com.example.todolistapp.domain.repository.AddCompletedTaskRepository

class AddCompletedTaskRepositoryImpl(private val dao: CompletedTaskDao): AddCompletedTaskRepository {

    override suspend fun addCompletedTask(task: CompletedTaskData) = dao.addCompletedTask(task)

}