package com.example.todolistapp.di

import com.example.todolistapp.data.repositoryImpl.AddCompletedTaskRepositoryImpl
import com.example.todolistapp.data.repositoryImpl.AddTaskRepositoryImpl
import com.example.todolistapp.data.repositoryImpl.AllCompletedTasksRepositoryImpl
import com.example.todolistapp.data.repositoryImpl.AllTasksRepositoryImpl
import com.example.todolistapp.data.repositoryImpl.DeleteCompletedTaskRepositoryImpl
import com.example.todolistapp.data.repositoryImpl.DeleteTaskRepositoryImpl
import com.example.todolistapp.data.repositoryImpl.UpdateTaskRepositoryImpl
import com.example.todolistapp.domain.repository.AddCompletedTaskRepository
import com.example.todolistapp.domain.repository.AddTaskRepository
import com.example.todolistapp.domain.repository.AllCompletedTasksRepository
import com.example.todolistapp.domain.repository.AllTasksRepository
import com.example.todolistapp.domain.repository.DeleteCompletedTaskRepository
import com.example.todolistapp.domain.repository.DeleteTaskRepository
import com.example.todolistapp.domain.repository.UpdateTaskRepository
import org.koin.dsl.module

val dataModule = module {
    single<AddTaskRepository> {
        AddTaskRepositoryImpl(get())
    }

    single<AllTasksRepository> {
        AllTasksRepositoryImpl(get())
    }

    single<UpdateTaskRepository> {
        UpdateTaskRepositoryImpl(get())
    }

    single<DeleteTaskRepository> {
        DeleteTaskRepositoryImpl(get())
    }

    single<AddCompletedTaskRepository> {
        AddCompletedTaskRepositoryImpl(get())
    }

    single<AllCompletedTasksRepository> {
        AllCompletedTasksRepositoryImpl(get())
    }

    single<DeleteCompletedTaskRepository> {
        DeleteCompletedTaskRepositoryImpl(get())
    }
}