package com.example.watcherapp.network.converter

data class allresults(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)