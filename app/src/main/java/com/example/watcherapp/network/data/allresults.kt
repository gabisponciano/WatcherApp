package com.example.watcherapp.network.data

data class allresults(
    val page: Int,
    val results: List<Resultm>,
    val total_pages: Int,
    val total_results: Int
)