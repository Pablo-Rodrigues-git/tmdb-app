package com.pablo.study.tmdb_app.features.list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.pablo.study.tmdb_app.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private val viewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.getAllMovies()
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.listStateFlow.collect { listUiState ->
                when (listUiState) {
                    is ListUiState.Error -> TODO()
                    is ListUiState.Loading -> TODO()
                    is ListUiState.Success -> TODO()
                }
            }
        }
    }
}