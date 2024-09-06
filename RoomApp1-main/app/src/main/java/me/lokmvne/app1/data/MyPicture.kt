package me.lokmvne.app1.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyPicture(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val url: String,
    val description: String,
    val date: String,
    val location: String
)
