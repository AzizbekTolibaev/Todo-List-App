package com.example.todolistapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todolistapp.data.TaskData

@Dao
interface TasksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTask(task: TaskData)

    @Query("SELECT * FROM tasks_table")
    suspend fun getAllTasks(): List<TaskData>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(task: TaskData)

    @Delete
    suspend fun deleteTask(task: TaskData)

}