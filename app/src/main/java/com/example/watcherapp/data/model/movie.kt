package com.example.watcherapp.data.model

data class movie(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)