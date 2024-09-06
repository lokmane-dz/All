package me.lokmvne.base.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

val Context.MySettingsPreferences: DataStore<Preferences> by preferencesDataStore(name = "SettingsPreferences")

class SettingsPreferences(context: Context) {
    private object PreferencesKeys {
        val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
        val DARK_MODE = booleanPreferencesKey("dark_mode")
    }

    private val datastore = context.MySettingsPreferences

    suspend fun saveOnboardingCompleted() {
        datastore.edit { preferences ->
            preferences[PreferencesKeys.ONBOARDING_COMPLETED] = true
        }
    }

    suspend fun readOnboardingCompleted(): Boolean {
        return datastore.data.first()[PreferencesKeys.ONBOARDING_COMPLETED] ?: false
    }

    suspend fun saveDarkMode(darkMode: Boolean) {
        datastore.edit { preferences ->
            preferences[PreferencesKeys.DARK_MODE] = darkMode
        }
    }

    suspend fun readDarkMode(): Boolean {
        return datastore.data.first()[PreferencesKeys.DARK_MODE] ?: false
    }

// Another method to read data:
//    fun readOnboardingCompleted(): Flow<Boolean> {
//        return datastore.data
//            .catch {
//                if (it is IOException) {
//                    emit(emptyPreferences())
//                } else {
//                    throw it
//                }
//            }.map {
//                val onBoardingState = it[PreferencesKeys.ONBOARDING_COMPLETED] ?: false
//                onBoardingState
//            }
//    }
}