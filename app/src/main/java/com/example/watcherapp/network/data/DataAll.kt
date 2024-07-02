package com.example.watcherapp.network.data

interface MediaItem {

    val id: Int
    val name: String
    val imageUrl: String
}

data class Movie(
    override val id: Int,
    val tittle: String,
    val popularity: Double,
    val release_date: String,
    val overview: String,
    val poster_path: String,
    override val name: String
) : MediaItem {
    override val imageUrl get() = "https://image.tmdb.org/t/p/w500$poster_path"
}

data class TvShow(
    override val id: Int,
    override val name: String,
    val first_air_date: String,
    val overview: String,
    val poster_path: String
) : MediaItem {
    override val imageUrl get() = "https://image.tmdb.org/t/p/w500$poster_path"
}

data class DetailsMovie(
    val id: Int,
    val imdbId: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
)