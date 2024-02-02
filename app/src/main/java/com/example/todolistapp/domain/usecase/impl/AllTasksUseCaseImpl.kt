package com.example.todolistapp.domain.usecase.impl

import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.repository.AllTasksRepository
import com.example.todolistapp.domain.usecase.AllTasksUseCase

class AllTasksUseCaseImpl(private val repository: AllTasksRepository): AllTasksUseCase {

    override suspend fun execute(): List<TaskData> {
        return repository.getAllTasks()
    }
}