package com.example.todolistapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.domain.usecase.AllTasksUseCase

class AllTasksViewModel(private val useCase: AllTasksUseCase): ViewModel() {

    private val _getAllTasksLiveData = MutableLiveData<List<TaskData>>()
    val getAllTasksLiveData: LiveData<List<TaskData>> get() = _getAllTasksLiveData

    suspend fun getAllTasks() {
        _getAllTasksLiveData.value = useCase.execute()
    }
}