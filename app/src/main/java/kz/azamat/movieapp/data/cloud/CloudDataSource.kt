package kz.azamat.movieapp.data.cloud

import kz.azamat.movieapp.api.RestApi
import javax.inject.Inject

class CloudDataSource @Inject constructor(private val api: RestApi){

    fun getMovieList() {
        api.requestMovieList()
    }

}