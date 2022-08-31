package com.pablo.study.tmdb_app.data.remote

import com.pablo.study.tmdb_app.data.model.ListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("/3/movie/popular")
    suspend fun getAllMovies(
        @Query("api_key") apiKey: String = "6fc65751e19034b021256a5c7960a780",
        @Query("language") language: String = "en-US",
        @Query("page") page: String = "1"
    ): Response<ListResponse>
}

