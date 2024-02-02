package com.example.todolistapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks_table")
data class TaskData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val detail: String
)
