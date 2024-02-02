package com.example.todolistapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "completed_tasks_table")
data class CompletedTaskData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val detail: String
)