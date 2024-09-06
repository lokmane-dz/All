package me.lokmvne.beaapp.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAll(beer: List<BeerEntity>)


    @Query("SELECT * FROM beerentity")
    fun pagingSource(): PagingSource<Int, BeerEntity>

    @Query("DELETE FROM beerentity")
    suspend fun clearAll()
}