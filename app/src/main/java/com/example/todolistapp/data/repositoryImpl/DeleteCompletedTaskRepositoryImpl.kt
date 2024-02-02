package com.example.todolistapp.data.repositoryImpl

import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.dao.CompletedTaskDao
import com.example.todolistapp.domain.repository.DeleteCompletedTaskRepository

class DeleteCompletedTaskRepositoryImpl(private val dao: CompletedTaskDao): DeleteCompletedTaskRepository {

    override suspend fun deleteCompletedTask(task: CompletedTaskData) = dao.deleteCompletedTask(task)
}
