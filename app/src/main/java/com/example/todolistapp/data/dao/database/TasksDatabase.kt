package com.example.todolistapp.data.dao.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.data.dao.CompletedTaskDao
import com.example.todolistapp.data.dao.TasksDao

@Database(entities = [TaskData::class, CompletedTaskData::class], version = 4)
abstract class TasksDatabase: RoomDatabase() {

    abstract fun getTaskDao(): TasksDao
    abstract fun getCompletedTaskDao(): CompletedTaskDao

    companion object {
        const val DATABASE_NAME = "db_name"

        fun getInstance(context: Context): TasksDatabase {
            return Room.databaseBuilder(
                context, TasksDatabase::class.java, DATABASE_NAME
            ).fallbackToDestructiveMigration().build()
        }
    }
}
