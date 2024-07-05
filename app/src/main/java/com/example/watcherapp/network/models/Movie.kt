package com.example.watcherapp.network.models

import com.google.gson.annotations.SerializedName

data class Moviee(
    var id: String,
    @SerializedName("original_title") var name: String,
    var description: String,
    @SerializedName("poster_path") var poster: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var voteAverage: String,
)