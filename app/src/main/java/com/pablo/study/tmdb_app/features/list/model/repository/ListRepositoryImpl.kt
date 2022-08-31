package com.pablo.study.tmdb_app.features.list.model.repository

import com.pablo.study.tmdb_app.data.model.ListResponse
import com.pablo.study.tmdb_app.features.list.model.datasource.ListRemoteDataSource
import com.pablo.study.tmdb_app.utils.Resource

class ListRepositoryImpl(
    private val remoteDataSource: ListRemoteDataSource
) : ListRepository {
    override suspend fun getAllMovies(): Resource<ListResponse> {
        val response = remoteDataSource.getAllMovies()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                Resource.success(responseBody)
            } else {
                Resource.error(data = null, message = response.message())
            }
        } else {
            Resource.error(data = null, message = response.message())
        }
    }
}