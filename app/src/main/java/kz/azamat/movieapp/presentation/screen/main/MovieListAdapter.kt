package kz.azamat.movieapp.presentation.screen.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import kz.azamat.movieapp.R
import kz.azamat.movieapp.presentation.models.MovieUi

class MovieListAdapter: RecyclerView.Adapter<MovieListAdapter.MovieItemViewHolder>(){

    private val items = mutableListOf<MovieUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return  MovieItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun setItems(movieList: List<MovieUi>) {
        items.addAll(movieList)
        notifyDataSetChanged()
    }

    inner class MovieItemViewHolder(itemView: View): ViewHolder(itemView) {

        fun bind(movie: MovieUi) {
            val movieImage = itemView.findViewById<ImageView>(R.id.movieImageView)
            val title = itemView.findViewById<TextView>(R.id.movieTitleTextView)
            val genre = itemView.findViewById<TextView>(R.id.movieGenreTextView)

            movieImage.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.mipmap.ic_launcher))
            title.text = movie.movieName
            genre.text = movie.movieGenre
            Glide.with(itemView.context)
                .load(movie.movieImage)
                .into(movieImage)

        }
    }
}