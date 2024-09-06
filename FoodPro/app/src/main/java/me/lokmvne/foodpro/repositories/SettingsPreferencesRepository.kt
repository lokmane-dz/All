package me.lokmvne.foodpro.repositories

import me.lokmvne.base.utils.SettingsPreferences
import javax.inject.Inject

class SettingsPreferencesRepository @Inject constructor(
    private val settingsPreferences: SettingsPreferences
) {
    suspend fun setDarkMode(isDarkMode: Boolean) {
        settingsPreferences.saveDarkMode(isDarkMode)
    }

    suspend fun getDarkMode(): Boolean {
        return settingsPreferences.readDarkMode()
    }

    suspend fun setOnboardingCompleted() {
        settingsPreferences.saveOnboardingCompleted()
    }

    suspend fun getOnboardingCompleted(): Boolean {
        return settingsPreferences.readOnboardingCompleted()
    }
}