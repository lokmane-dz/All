package me.lokmvne.app1.presentation.viewmodels

import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import me.lokmvne.app1.data.MyPicture
import me.lokmvne.app1.repository.repository
import me.lokmvne.app1.utils.Resource
import javax.inject.Inject

@HiltViewModel
class GetPicturesViewModel @Inject constructor(private val repository: repository) : ViewModel() {

    private val _pictureList = MutableStateFlow<Resource<List<MyPicture>>>(Resource.Loading())
    //val pictureList: StateFlow<Resource<List<MyPicture>>> = _pictureList

    var pictures = mutableStateOf<List<MyPicture>>(listOf())

    var isloading = mutableStateOf(_pictureList.value is Resource.Loading)

    fun getPicture(context: Context) {
        viewModelScope.launch {
            delay(1000)
            _pictureList.value = repository.getPicture()

            _pictureList.value.let {
                when (it) {
                    is Resource.Error -> {
                        isloading.value = false
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }

                    is Resource.Loading -> {
                        isloading.value = true
                    }

                    is Resource.Success -> {
                        if (it.data!!.isEmpty()) {
                            isloading.value = false
                            Toast.makeText(context, "No pictures found", Toast.LENGTH_SHORT).show()
                        } else {
                            isloading.value = false
                            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                            pictures.value = it.data
                        }
                    }
                }
            }
        }
    }
}