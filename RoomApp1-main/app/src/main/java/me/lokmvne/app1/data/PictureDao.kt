package me.lokmvne.app1.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PictureDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun AddPicture(myPicture: MyPicture): Long

    @Query("SELECT * FROM mypicture ORDER BY id ASC")
    suspend fun getAll(): List<MyPicture>

}