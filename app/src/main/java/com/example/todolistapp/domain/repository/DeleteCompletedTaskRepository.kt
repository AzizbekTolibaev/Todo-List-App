package com.example.todolistapp.domain.repository

import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData

interface DeleteCompletedTaskRepository {

    suspend fun deleteCompletedTask(task: CompletedTaskData)
}