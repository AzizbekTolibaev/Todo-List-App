package com.example.todolistapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.usecase.AddTaskUseCase

class AddTaskViewModel(private val useCase: AddTaskUseCase): ViewModel() {

    suspend fun addTask(task: TaskData) {
        useCase.execute(task)
    }
}