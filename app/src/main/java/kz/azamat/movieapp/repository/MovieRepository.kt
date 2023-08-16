package kz.azamat.movieapp.repository

import kz.azamat.movieapp.api.RestApi
import kz.azamat.movieapp.data.MoviesListCloud
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val restApi: RestApi) {

    suspend fun search(): Response<MoviesListCloud> {
        return restApi.search()
    }

}