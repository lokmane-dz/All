package me.lokmvne.losounds.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.lokmvne.losounds.data.DataStoreRepository
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {
    fun saveOnboardingCompleted() {
        viewModelScope.launch {
            dataStoreRepository.saveOnboardingCompleted()
        }
    }
}