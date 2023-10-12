package com.example.appiskeytask.api

import com.example.appiskeytask.model.YourResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/")
    suspend fun getImages(
        @Query("key") apiKey: String,
        @Query("q") query: String,
        @Query("image_type") imageType: String,
        @Query("pretty") pretty: Boolean
    ): Response<YourResponseModel>
}