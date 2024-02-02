package com.example.todolistapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.usecase.AddCompletedTaskUseCase

class AddCompletedTaskViewModel(private val useCase: AddCompletedTaskUseCase): ViewModel() {

    suspend fun addCompletedTask(task: CompletedTaskData) {
        useCase.execute(task)
    }
}
