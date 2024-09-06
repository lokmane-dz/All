package me.lokmvne.foodpro.presentation.ui.start.onBoarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.lokmvne.foodpro.repositories.SettingsPreferencesRepository
import javax.inject.Inject

@HiltViewModel
class OnbOardingViewModel @Inject constructor(
    private val settingsPreferencesRepository: SettingsPreferencesRepository
) : ViewModel() {
    fun setOnboardingCompleted() {
        viewModelScope.launch {
            settingsPreferencesRepository.setOnboardingCompleted()
        }
    }

}