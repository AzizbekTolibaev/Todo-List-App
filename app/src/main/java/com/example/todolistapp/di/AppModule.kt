package com.example.todolistapp.di

import com.example.todolistapp.presentation.viewModel.AddCompletedTaskViewModel
import com.example.todolistapp.presentation.viewModel.AddTaskViewModel
import com.example.todolistapp.presentation.viewModel.AllCompletedTaskViewModel
import com.example.todolistapp.presentation.viewModel.AllTasksViewModel
import com.example.todolistapp.presentation.viewModel.DeleteCompletedTaskViewModel
import com.example.todolistapp.presentation.viewModel.DeleteTaskViewModel
import com.example.todolistapp.presentation.viewModel.UpdateTaskViewModel
import org.koin.dsl.module

val appModule = module {
    single {
        AddTaskViewModel(get())
    }

    single {
        AllTasksViewModel(get())
    }

    single {
        UpdateTaskViewModel(get())
    }

    single {
        DeleteTaskViewModel(get())
    }

    single {
        AddCompletedTaskViewModel(get())
    }

    single {
        AllCompletedTaskViewModel(get())
    }

    single {
        DeleteCompletedTaskViewModel(get())
    }
}