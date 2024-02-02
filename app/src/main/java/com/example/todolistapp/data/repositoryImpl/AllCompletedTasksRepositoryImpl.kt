package com.example.todolistapp.data.repositoryImpl

import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.data.dao.CompletedTaskDao
import com.example.todolistapp.domain.repository.AllCompletedTasksRepository

class AllCompletedTasksRepositoryImpl(private val dao: CompletedTaskDao): AllCompletedTasksRepository {

    override suspend fun getAllCompletedTasksRepository(): List<CompletedTaskData> {
        return dao.getAllCompletedTasks()
    }
}
