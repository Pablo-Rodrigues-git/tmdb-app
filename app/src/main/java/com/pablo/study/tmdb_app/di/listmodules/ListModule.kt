package com.pablo.study.tmdb_app.di.listmodules

import com.pablo.study.tmdb_app.features.list.model.datasource.ListRemoteDataSource
import com.pablo.study.tmdb_app.features.list.model.datasource.ListRemoteDataSourceImpl
import com.pablo.study.tmdb_app.features.list.model.repository.ListRepository
import com.pablo.study.tmdb_app.features.list.model.repository.ListRepositoryImpl
import com.pablo.study.tmdb_app.features.list.presentation.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listModule = module {
    factory<ListRemoteDataSource> {
        ListRemoteDataSourceImpl(
            service = get()
        )
    }
    factory<ListRepository> {
        ListRepositoryImpl(
            remoteDataSource = get()
        )
    }
    viewModel {
        ListViewModel(
            repository = get()
        )
    }
}