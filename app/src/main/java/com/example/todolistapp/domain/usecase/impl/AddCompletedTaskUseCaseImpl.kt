package com.example.todolistapp.domain.usecase.impl

import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.repository.AddCompletedTaskRepository
import com.example.todolistapp.domain.usecase.AddCompletedTaskUseCase

class AddCompletedTaskUseCaseImpl(private val repository: AddCompletedTaskRepository): AddCompletedTaskUseCase {

    override suspend fun execute(task: CompletedTaskData) = repository.addCompletedTask(task)
}