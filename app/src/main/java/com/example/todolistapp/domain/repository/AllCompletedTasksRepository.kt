package com.example.todolistapp.domain.repository

import com.example.todolistapp.data.CompletedTaskData

interface AllCompletedTasksRepository {

    suspend fun getAllCompletedTasksRepository(): List<CompletedTaskData>
}