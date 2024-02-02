package com.example.todolistapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData

@Dao
interface CompletedTaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCompletedTask(task: CompletedTaskData)

    @Query("SELECT * FROM completed_tasks_table")
    suspend fun getAllCompletedTasks(): List<CompletedTaskData>

    @Delete
    suspend fun deleteCompletedTask(task: CompletedTaskData)
}