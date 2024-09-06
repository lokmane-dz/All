package me.lokmvne.app1.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyPicture::class], version = 1)
abstract class PictureDB : RoomDatabase() {
    abstract fun pictureDao(): PictureDao
}