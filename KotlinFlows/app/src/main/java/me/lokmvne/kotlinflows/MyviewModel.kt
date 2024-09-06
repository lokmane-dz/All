package me.lokmvne.kotlinflows

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyviewModel : ViewModel() {
    var enabled = mutableStateOf(true)
    val count = mutableStateOf(10)


    private val _stateflow = MutableStateFlow(0)
    val stateFlow = _stateflow.asStateFlow()

    fun collectFlow() {
        viewModelScope.launch {
            _stateflow.value++
        }
    }
}