package com.pablo.study.tmdb_app.features.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablo.study.tmdb_app.data.model.MovieResponse
import com.pablo.study.tmdb_app.features.list.model.repository.ListRepository
import com.pablo.study.tmdb_app.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: ListRepository
) : ViewModel() {

    private val _listStateFlow =
        MutableStateFlow<ListUiState>(ListUiState.Loading(isLoading = false))
    val listStateFlow: StateFlow<ListUiState> get() = _listStateFlow

    fun getAllMovies() = viewModelScope.launch(Dispatchers.IO) {
        _listStateFlow.value = ListUiState.Loading(true)
        val response = repository.getAllMovies()
        when (response.status) {
            Status.SUCCESS -> {
                _listStateFlow.value = ListUiState.Loading(false)
                response.data?.let {
                    _listStateFlow.value = ListUiState.Success(it)
                }
            }
            Status.ERROR -> {
                _listStateFlow.value = ListUiState.Loading(false)
                response.message?.let {
                    _listStateFlow.value = ListUiState.Error(it)
                }
            }
        }
    }
}

sealed class ListUiState {
    data class Success(val list: List<MovieResponse>) : ListUiState()
    data class Error(val exception: String) : ListUiState()
    data class Loading(val isLoading: Boolean) : ListUiState()

}