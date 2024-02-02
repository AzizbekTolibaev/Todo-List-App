package com.example.todolistapp.domain.usecase.impl

import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.repository.AddTaskRepository
import com.example.todolistapp.domain.usecase.AddTaskUseCase

class AddTaskUseCaseImpl(private val repository: AddTaskRepository): AddTaskUseCase {

    override suspend fun execute(task: TaskData) = repository.addTask(task)
}