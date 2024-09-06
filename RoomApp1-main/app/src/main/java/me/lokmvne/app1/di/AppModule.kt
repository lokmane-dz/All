package me.lokmvne.app1.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.lokmvne.app1.data.PictureDB
import me.lokmvne.app1.data.PictureDao
import me.lokmvne.app1.repository.repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesContext(@ApplicationContext context: Context) = context

    @Provides
    @Singleton
    fun providesRepository(dao: PictureDao) = repository(dao)

    @Provides
    @Singleton
    fun providesDao(db: PictureDB) = db.pictureDao()

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): PictureDB {
        return Room.databaseBuilder(
            context,
            PictureDB::class.java,
            "picture_database"
        ).build()
    }
}