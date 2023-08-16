package kz.azamat.movieapp.presentation.screen.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kz.azamat.movieapp.data.MovieCloud
import kz.azamat.movieapp.data.MoviesListCloud
import kz.azamat.movieapp.repository.MovieRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MovieRepository): ViewModel() {

    private val _movieListLiveData = MutableLiveData<List<MovieCloud>>()

    val movieListLiveData: LiveData<List<MovieCloud>>
        get() = _movieListLiveData

    fun getMovieList() {
        viewModelScope.launch {
            val response = repository.search()
            if (response.isSuccessful) {
                response.body()?.let {
                    _movieListLiveData.value = it.list
                    Log.e("myLog", "getMovieList: " + response.body())
                }
            }
        }
//        _movieListLiveData.value = repository.test()
    }

}