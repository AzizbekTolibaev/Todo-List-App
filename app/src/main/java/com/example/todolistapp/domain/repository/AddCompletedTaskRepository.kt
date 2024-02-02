package com.example.todolistapp.domain.repository

import com.example.todolistapp.data.CompletedTaskData

interface AddCompletedTaskRepository {

    suspend fun addCompletedTask(task: CompletedTaskData)
}