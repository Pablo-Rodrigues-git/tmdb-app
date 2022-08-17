package com.pablo.study.tmdb_app.features.list.model.datasource

import com.pablo.study.tmdb_app.data.model.MovieResponse
import retrofit2.Response

interface ListRemoteDataSource {
    suspend fun getAllMovies() : Response<List<MovieResponse>>
}