package com.example.todolistapp.domain.usecase.impl

import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.repository.AllCompletedTasksRepository
import com.example.todolistapp.domain.usecase.AllCompletedTasksUseCase

class AllCompletedTasksUseCaseImpl(private val repository: AllCompletedTasksRepository): AllCompletedTasksUseCase {

    override suspend fun execute(): List<CompletedTaskData> {
        return repository.getAllCompletedTasksRepository()
    }
}