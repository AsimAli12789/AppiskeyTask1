package com.example.appiskeytask.model

data class YourResponseModel(
    val totalHits: Int,
    val total: Int,
    val hits: List<ImageData>
)