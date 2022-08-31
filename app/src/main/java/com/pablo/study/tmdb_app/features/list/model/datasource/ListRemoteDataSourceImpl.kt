package com.pablo.study.tmdb_app.features.list.model.datasource

import com.pablo.study.tmdb_app.data.model.ListResponse
import com.pablo.study.tmdb_app.data.remote.RetrofitService
import retrofit2.Response

class ListRemoteDataSourceImpl(
    private val service: RetrofitService
) : ListRemoteDataSource {
    override suspend fun getAllMovies(): Response<ListResponse> = service.getAllMovies()
}