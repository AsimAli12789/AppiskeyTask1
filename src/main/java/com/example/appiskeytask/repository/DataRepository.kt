package com.example.appiskeytask.repository

import com.example.appiskeytask.api.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getImages(query: String) = apiService.getImages("38437071-5f1d14114d464cb7440d92ebd", query, "photo", true)
}