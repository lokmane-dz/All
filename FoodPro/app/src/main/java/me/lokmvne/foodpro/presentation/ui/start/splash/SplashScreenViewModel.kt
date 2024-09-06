package me.lokmvne.foodpro.presentation.ui.start.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.lokmvne.foodpro.repositories.SettingsPreferencesRepository
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val settingsPreferencesRepository: SettingsPreferencesRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private var _OnboardingStatus = MutableStateFlow<Boolean>(true)
    val OnboardingStatus: StateFlow<Boolean> = _OnboardingStatus

    fun getOnboardingStatus() {

        val onboardingres = viewModelScope.async {
            _OnboardingStatus.value = settingsPreferencesRepository.getOnboardingCompleted()
        }

        onboardingres.invokeOnCompletion {
            _isLoading.value = false
        }
    }
}