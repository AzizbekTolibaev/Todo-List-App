package com.example.todolistapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.usecase.DeleteCompletedTaskUseCase

class DeleteCompletedTaskViewModel(private val useCase: DeleteCompletedTaskUseCase): ViewModel() {

    suspend fun deleteCompletedTask(task: CompletedTaskData) {
        useCase.execute(task)
    }
}