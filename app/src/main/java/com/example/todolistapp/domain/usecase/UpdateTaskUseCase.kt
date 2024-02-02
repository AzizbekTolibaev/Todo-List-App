package com.example.todolistapp.domain.usecase

import com.example.todolistapp.data.TaskData

interface UpdateTaskUseCase {

    suspend fun execute(task: TaskData)
}