package com.example.todolistapp.domain.repository

import com.example.todolistapp.data.TaskData

interface AllTasksRepository {
    suspend fun getAllTasks(): List<TaskData>
}