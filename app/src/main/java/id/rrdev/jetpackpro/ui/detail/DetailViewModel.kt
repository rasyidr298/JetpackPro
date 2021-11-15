package id.rrdev.jetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import id.rrdev.jetpackpro.data.Movie
import id.rrdev.jetpackpro.utils.MovieDummy

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovies() : Movie {
        lateinit var movieEntity : Movie

        val movieTempEntity : MutableList<Movie> = mutableListOf()

        val movieEntities = MovieDummy.getMovies()
        val tvShowsEntites = MovieDummy.getTvShow()

        movieTempEntity.addAll(movieEntities)
        movieTempEntity.addAll(tvShowsEntites)

        for (movie in movieTempEntity) {
            if (movie.id == movieId) {
                movieEntity = movie
            }
        }

        return movieEntity
    }

}