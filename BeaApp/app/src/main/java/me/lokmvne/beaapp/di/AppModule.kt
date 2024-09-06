package me.lokmvne.beaapp.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.lokmvne.beaapp.data.local.BeerDatabase
import me.lokmvne.beaapp.data.local.BeerEntity
import me.lokmvne.beaapp.data.remote.BeerApi
import me.lokmvne.beaapp.data.remote.BeerRemoteMediator
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBeerDatabase(@ApplicationContext context: Context): BeerDatabase {
        return Room.databaseBuilder(
            context,
            BeerDatabase::class.java,
            "beer.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesBeerApi(): BeerApi {
        return Retrofit.Builder()
            .baseUrl(BeerApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(BeerApi::class.java)
    }


    @Provides
    @Singleton
    fun providesBeerPager(beerDb: BeerDatabase, beerApi: BeerApi): Pager<Int, BeerEntity> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            remoteMediator = BeerRemoteMediator(beerDb, beerApi),
            pagingSourceFactory = { beerDb.dao.pagingSource() }
        )
    }
}