package com.example.watcherapp.network.data

import com.google.gson.annotations.SerializedName

interface MediaItem {

    val id: Int
    val name: String
    val imageUrl: String
}

data class Movie(
    override val id: Int,
    val tittle: String,
    val popularity: Double,
    @SerializedName("release_date") val releaseDate: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    override val name: String,
    var runtime: Int,
    val tagline: String
) : MediaItem {
    override val imageUrl get() = "https://image.tmdb.org/t/p/w500$posterPath"
}
//Ajeitar isso
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



data class MovieSerial(
    @SerializedName ("id") var id: String,
    @SerializedName ("original_title") var originalTitle: String,
    @SerializedName ("overview") var overview: String,
    @SerializedName ("poster_path") var posterPath: String,
    @SerializedName ("release_date") var releaseDate: String,
    @SerializedName ("vote_average") var voteAverage: String
)