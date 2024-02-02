package com.example.todolistapp.domain.usecase.impl

import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.repository.DeleteTaskRepository
import com.example.todolistapp.domain.usecase.DeleteTaskUseCase

class DeleteTaskUseCaseImpl(private val repository: DeleteTaskRepository): DeleteTaskUseCase {

    override suspend fun deleteTask(task: TaskData) = repository.deleteTask(task)
}