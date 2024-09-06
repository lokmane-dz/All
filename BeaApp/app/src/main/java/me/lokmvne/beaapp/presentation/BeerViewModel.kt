package me.lokmvne.beaapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import me.lokmvne.beaapp.data.local.BeerEntity
import me.lokmvne.beaapp.data.mappers.toBeer
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(private val pager: Pager<Int, BeerEntity>) : ViewModel() {
//    val _beers = MutableStateFlow(emptyList<Beer>())
//    val beers: StateFlow<List<Beer>> = _beers


    val beers = pager.flow
        .map { pagingData ->
            pagingData.map { it.toBeer() }
        }
        .cachedIn(viewModelScope)

}