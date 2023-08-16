package kz.azamat.movieapp.api

import kz.azamat.movieapp.data.MoviesListCloud
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

//https://www.omdbapi.com/ API
const val API_KEY = "e8945080"
interface RestApi {

    @GET("?s=Batman&plot=full&apikey=$API_KEY")
    suspend fun search(): Response<MoviesListCloud>

}