package com.example.todolistapp.di

import com.example.todolistapp.domain.usecase.AddCompletedTaskUseCase
import com.example.todolistapp.domain.usecase.AddTaskUseCase
import com.example.todolistapp.domain.usecase.AllCompletedTasksUseCase
import com.example.todolistapp.domain.usecase.AllTasksUseCase
import com.example.todolistapp.domain.usecase.DeleteCompletedTaskUseCase
import com.example.todolistapp.domain.usecase.DeleteTaskUseCase
import com.example.todolistapp.domain.usecase.UpdateTaskUseCase
import com.example.todolistapp.domain.usecase.impl.AddCompletedTaskUseCaseImpl
import com.example.todolistapp.domain.usecase.impl.AddTaskUseCaseImpl
import com.example.todolistapp.domain.usecase.impl.AllCompletedTasksUseCaseImpl
import com.example.todolistapp.domain.usecase.impl.AllTasksUseCaseImpl
import com.example.todolistapp.domain.usecase.impl.DeleteCompletedTaskUseCaseImpl
import com.example.todolistapp.domain.usecase.impl.DeleteTaskUseCaseImpl
import com.example.todolistapp.domain.usecase.impl.UpdateTaskUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<AddTaskUseCase> {
        AddTaskUseCaseImpl(get())
    }

    factory<AllTasksUseCase> {
        AllTasksUseCaseImpl(get())
    }

    factory<UpdateTaskUseCase> {
        UpdateTaskUseCaseImpl(get())
    }

    factory<DeleteTaskUseCase> {
        DeleteTaskUseCaseImpl(get())
    }

    factory<AddCompletedTaskUseCase> {
        AddCompletedTaskUseCaseImpl(get())
    }

    factory<AllCompletedTasksUseCase> {
        AllCompletedTasksUseCaseImpl(get())
    }

    factory<DeleteCompletedTaskUseCase> {
        DeleteCompletedTaskUseCaseImpl(get())
    }
}