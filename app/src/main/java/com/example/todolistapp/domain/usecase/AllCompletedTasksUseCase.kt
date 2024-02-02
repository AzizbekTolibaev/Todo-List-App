package com.example.todolistapp.domain.usecase

import com.example.todolistapp.data.CompletedTaskData

interface AllCompletedTasksUseCase {

    suspend fun execute(): List<CompletedTaskData>
}