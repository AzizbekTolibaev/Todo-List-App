package com.example.todolistapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.usecase.DeleteTaskUseCase

class DeleteTaskViewModel(private val useCase: DeleteTaskUseCase): ViewModel() {

    suspend fun deleteTask(task: TaskData) {
        useCase.deleteTask(task)
    }
}