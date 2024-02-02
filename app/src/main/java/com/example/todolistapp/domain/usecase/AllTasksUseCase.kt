package com.example.todolistapp.domain.usecase

import com.example.todolistapp.data.TaskData

interface AllTasksUseCase {

    suspend fun execute(): List<TaskData>
}