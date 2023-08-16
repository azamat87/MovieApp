package kz.azamat.movieapp.presentation.screen.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kz.azamat.movieapp.R
import kz.azamat.movieapp.presentation.models.MovieUi

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieRv = view.findViewById<RecyclerView>(R.id.movieRecyclerView)
        val adapter = MovieListAdapter()

        movieRv.layoutManager = GridLayoutManager(requireContext(), 2)
        movieRv.adapter = adapter

        viewModel.getMovieList()
//        viewModel.movieListLiveData.observe(viewLifecycleOwner) {
//            view.findViewById<TextView>(R.id.textView).text = it
//        }
//        viewModel.getMovieList()

        viewModel.movieListLiveData.observe(viewLifecycleOwner) { movieList ->
            val list = movieList.map {
                MovieUi(id = it.imdbID, movieName = it.title, movieImage = it.poster, movieGenre = "")
            }.toList()
            adapter.setItems(list)
        }

    }

//    private fun testData() = listOf(
//        MovieUi(1, "Spider man", "", "genre"),
//        MovieUi(2, "Spider man 2", "", "genre"),
//        MovieUi(3, "Spider man 3", "", "genre"),
//        MovieUi(4, "Star wars 1", "", "genre"),
//        MovieUi(5, "Star wars 2", "", "genre"),
//        MovieUi(6, "Star wars 3", "", "genre"),
//        MovieUi(7, "Star wars 4", "", "genre"),
//        MovieUi(8, "Star wars 5", "", "genre"),
//    )

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}