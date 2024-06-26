package com.example.watcherapp.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesPhoto(
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)
