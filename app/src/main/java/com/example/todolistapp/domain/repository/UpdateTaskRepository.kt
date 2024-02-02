package com.example.todolistapp.domain.repository

import com.example.todolistapp.data.TaskData

interface UpdateTaskRepository {

    suspend fun updateTask(task: TaskData)
}