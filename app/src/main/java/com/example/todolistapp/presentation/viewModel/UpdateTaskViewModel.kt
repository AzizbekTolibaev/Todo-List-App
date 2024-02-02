package com.example.todolistapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.usecase.UpdateTaskUseCase

class UpdateTaskViewModel(private val useCase: UpdateTaskUseCase): ViewModel() {

    suspend fun updateTask(task: TaskData) {
        useCase.execute(task)
    }
}