package com.example.adilet_usupbekov_homework_4m.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.adilet_usupbekov_homework_4m.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao

}
