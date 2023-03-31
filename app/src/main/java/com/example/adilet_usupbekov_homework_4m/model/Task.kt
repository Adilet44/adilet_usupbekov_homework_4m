package com.example.adilet_usupbekov_homework_4m.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var title:String?=null,
    var description: String?=null,
):java.io.Serializable
