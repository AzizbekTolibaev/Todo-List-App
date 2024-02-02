package com.example.todolistapp.domain.usecase.impl

import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.repository.DeleteCompletedTaskRepository
import com.example.todolistapp.domain.usecase.DeleteCompletedTaskUseCase

class DeleteCompletedTaskUseCaseImpl(private val repository: DeleteCompletedTaskRepository): DeleteCompletedTaskUseCase {

    override suspend fun execute(task: CompletedTaskData) = repository.deleteCompletedTask(task)
}
