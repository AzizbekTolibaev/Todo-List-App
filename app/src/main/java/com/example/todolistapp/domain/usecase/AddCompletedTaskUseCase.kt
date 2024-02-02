package com.example.todolistapp.domain.usecase

import com.example.todolistapp.data.CompletedTaskData

interface AddCompletedTaskUseCase {

    suspend fun execute(task: CompletedTaskData)
}