package com.example.todolistapp.app

import android.app.Application
import com.example.todolistapp.di.appModule
import com.example.todolistapp.di.dataModule
import com.example.todolistapp.di.domainModule
import com.example.todolistapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, domainModule, dataModule, appModule))
        }
    }
}