package me.lokmvne.app1.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.lokmvne.app1.data.MyPicture
import me.lokmvne.app1.repository.repository
import javax.inject.Inject

@HiltViewModel
class AddPictureViewModel @Inject constructor(private val repository: repository) : ViewModel() {
    var title = mutableStateOf("")
    var url = mutableStateOf("")
    var description = mutableStateOf("")
    var date = mutableStateOf("")
    var location = mutableStateOf("")

    fun addPicture(myPicture: MyPicture) {
        viewModelScope.launch {
            repository.addPicture(myPicture)
        }
    }
}