package com.example.todolistapp.domain.usecase

import com.example.todolistapp.data.TaskData

interface DeleteTaskUseCase {

    suspend fun deleteTask(task: TaskData)
}