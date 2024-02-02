package com.example.todolistapp.domain.usecase

import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData

interface DeleteCompletedTaskUseCase {

    suspend fun execute(task: CompletedTaskData)
}