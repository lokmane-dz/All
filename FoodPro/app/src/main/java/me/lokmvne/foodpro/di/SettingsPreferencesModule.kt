package me.lokmvne.foodpro.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.lokmvne.base.utils.SettingsPreferences
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SettingsPreferencesModule {
    @Provides
    @Singleton
    fun provideSettingsPreferences(
        @ApplicationContext context: Context
    ) = SettingsPreferences(context)

    @Provides
    @Singleton
    fun provideContext(
        @ApplicationContext context: Context
    ) = context
}