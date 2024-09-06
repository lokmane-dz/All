package me.lokmvne.losounds.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

val Context.MydataStore: DataStore<Preferences> by preferencesDataStore(name = "onboarding_pref")

class DataStoreRepository(context: Context) {
    private object PreferencesKeys {
        val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
    }

    private val datastore = context.MydataStore

    suspend fun saveOnboardingCompleted() {
        datastore.edit { preferences ->
            preferences[PreferencesKeys.ONBOARDING_COMPLETED] = true
        }
    }

    fun readOnboardingCompleted(): Flow<Boolean> {
        return datastore.data
            .catch {
                if (it is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
                val onBoardingState = it[PreferencesKeys.ONBOARDING_COMPLETED] ?: false
                onBoardingState
            }
    }
}