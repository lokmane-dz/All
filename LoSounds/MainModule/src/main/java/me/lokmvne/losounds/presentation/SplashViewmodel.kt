package me.lokmvne.losounds.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import me.lokmvne.losounds.data.DataStoreRepository
import javax.inject.Inject

@HiltViewModel
class SplashViewmodel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _startDestination = MutableStateFlow(Screens.WelcomeScreen.route)
    val startDestination: StateFlow<String> = _startDestination


    init {
        viewModelScope.launch {
            dataStoreRepository.readOnboardingCompleted()
                .collect {
                    if (it) {
                        _startDestination.value = Screens.HomeScreen.route

                    } else {
                        _startDestination.value = Screens.WelcomeScreen.route
                    }
                }
        }
    }
}