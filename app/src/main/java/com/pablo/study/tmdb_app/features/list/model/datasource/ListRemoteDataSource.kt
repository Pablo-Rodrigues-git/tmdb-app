package com.pablo.study.tmdb_app.features.list.model.datasource

import com.pablo.study.tmdb_app.data.model.ListResponse
import retrofit2.Response

interface ListRemoteDataSource {
    suspend fun getAllMovies() : Response<ListResponse>
}