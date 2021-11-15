package id.rrdev.jetpackpro.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import id.rrdev.jetpackpro.data.Movie
import id.rrdev.jetpackpro.ui.adapter.MovieAdapter
import id.rrdev.jetpackpro.databinding.MovieFragmentBinding
import id.rrdev.jetpackpro.ui.detail.DetailActivity
import id.rrdev.jetpackpro.ui.detail.DetailActivity.Companion.MOVIE
import id.rrdev.jetpackpro.utils.OnItemClicked

class MovieFragment : Fragment(), OnItemClicked {

    private val binding : MovieFragmentBinding by lazy {
        MovieFragmentBinding.inflate(layoutInflater)
    }

    private lateinit var movieAdapter: MovieAdapter

    private val movieViewModel : MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupData()
    }

    override fun onEventClick(data: Movie) {
        super.onEventClick(data)
        Intent(activity,DetailActivity::class.java).let {
            it.putExtra(MOVIE,data.id)
            startActivity(it)
        }
    }

    private fun setupData() {
        val movies = movieViewModel.getDummyMovies()
        movieAdapter = MovieAdapter(this)
        movieAdapter.addList(movies)

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

}