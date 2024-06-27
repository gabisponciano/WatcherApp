package com.example.watcherapp.network.models

data class movies(
    val page: Int,
    val results: List<movie>,
    val total_pages: Int,
    val total_results: Int
)