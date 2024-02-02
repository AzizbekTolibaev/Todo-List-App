package com.example.todolistapp.domain.usecase

import com.example.todolistapp.data.TaskData

interface AddTaskUseCase {
    suspend fun execute(task: TaskData)
}