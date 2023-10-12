package com.example.appiskeytask.model

data class ImageData(
    val id: Int,
    val user: String,
    val largeImageURL: String,
    val tags: String,
    val likes: Int
)