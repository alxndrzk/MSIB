package com.example.suitmediatestalex.Api

import com.example.suitmediatestalex.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/users")
    suspend fun getUsers(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 6
    ): Response



}