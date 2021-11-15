package id.rrdev.jetpackpro.ui.movie

import androidx.lifecycle.ViewModel
import id.rrdev.jetpackpro.utils.MovieDummy

class MovieViewModel : ViewModel() {
    fun getDummyMovies() = MovieDummy.getMovies()
}