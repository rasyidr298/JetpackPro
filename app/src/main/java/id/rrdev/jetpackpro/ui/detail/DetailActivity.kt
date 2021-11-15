package id.rrdev.jetpackpro.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import id.rrdev.jetpackpro.data.Movie
import id.rrdev.jetpackpro.databinding.ActivityDetailBinding
import id.rrdev.jetpackpro.utils.load

class DetailActivity : AppCompatActivity() {

    private val binding : ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private val detailViewModel: DetailViewModel by viewModels()

    private var movie: String? = null

    companion object {
        const val MOVIE = "MOVIE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        movie = intent.getStringExtra(MOVIE)
        movie?.let { detailViewModel.setSelectedMovie(it) }
        populateMovie(detailViewModel.getMovies())
    }

    private fun populateMovie(movie: Movie) {
        with(binding) {
            imgDetailMovie.load(movie.image)
            txtOverview.text = movie.overview
            txtGenre.text = movie.genre
            txtDateOfRelease.text = movie.dateOfRelease
            txtDuration.text = movie.duration
            txtTitleMovie.text = movie.title
        }
    }
}