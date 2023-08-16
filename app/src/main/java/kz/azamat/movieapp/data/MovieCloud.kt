package kz.azamat.movieapp.data

import com.google.gson.annotations.SerializedName

data class MoviesListCloud (
    @SerializedName("Search")
    val list: List<MovieCloud>
)

data class MovieCloud(
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Poster")
    val poster: String
)
