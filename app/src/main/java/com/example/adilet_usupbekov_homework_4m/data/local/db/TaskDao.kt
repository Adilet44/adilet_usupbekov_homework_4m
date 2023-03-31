package com.example.adilet_usupbekov_homework_4m.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.adilet_usupbekov_homework_4m.model.Task

@Dao

interface TaskDao {

    @Insert
    fun insert(task:Task)

    @Delete
    fun delete (task: Task)

    @Query("SELECT * FROM task ORDER BY id DESC")
    fun getAll(): List<Task>
}