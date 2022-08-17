package com.pablo.study.tmdb_app.features.list.model.repository

import com.pablo.study.tmdb_app.data.model.MovieResponse
import com.pablo.study.tmdb_app.utils.Resource

interface ListRepository {
    suspend fun getAllMovies() : Resource <List<MovieResponse>>
}