package com.pablo.study.tmdb_app.data.remote

import com.pablo.study.tmdb_app.data.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("")
    suspend fun getAllMovies(): Response<List<MovieResponse>>
}

