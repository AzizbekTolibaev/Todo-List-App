package com.example.todolistapp.domain.usecase.impl

import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.repository.UpdateTaskRepository
import com.example.todolistapp.domain.usecase.UpdateTaskUseCase

class UpdateTaskUseCaseImpl(private val repository: UpdateTaskRepository): UpdateTaskUseCase {

    override suspend fun execute(task: TaskData) = repository.updateTask(task)
}