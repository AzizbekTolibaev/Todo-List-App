package com.example.todolistapp.domain.repository

import com.example.todolistapp.data.TaskData

interface DeleteTaskRepository {

    suspend fun deleteTask(task: TaskData)
}