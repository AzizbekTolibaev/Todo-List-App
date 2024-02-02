package com.example.todolistapp.domain.repository

import com.example.todolistapp.data.TaskData

interface AddTaskRepository {

    suspend fun addTask(task: TaskData)

}