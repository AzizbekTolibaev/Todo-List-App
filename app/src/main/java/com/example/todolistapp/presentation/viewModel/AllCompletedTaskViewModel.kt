package com.example.todolistapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.usecase.AllCompletedTasksUseCase

class AllCompletedTaskViewModel(private val useCase: AllCompletedTasksUseCase): ViewModel() {

    private val _getAllCompletedTasksLiveData = MutableLiveData<List<CompletedTaskData>>()
    val getAllCompletedTasksLivedata: LiveData<List<CompletedTaskData>> get() = _getAllCompletedTasksLiveData

    suspend fun getAllCompletedTasks() {
        _getAllCompletedTasksLiveData.value = useCase.execute()
    }
}