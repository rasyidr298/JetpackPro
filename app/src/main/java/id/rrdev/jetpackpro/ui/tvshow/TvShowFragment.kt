package id.rrdev.jetpackpro.ui.tvshow

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
import id.rrdev.jetpackpro.databinding.TvShowFragmentBinding
import id.rrdev.jetpackpro.ui.detail.DetailActivity
import id.rrdev.jetpackpro.utils.OnItemClicked

class TvShowFragment : Fragment(), OnItemClicked {

    private val binding : TvShowFragmentBinding by lazy {
        TvShowFragmentBinding.inflate(layoutInflater)
    }

    private val tvShowViewModel : TvShowViewModel by viewModels()
    private lateinit var adapter: MovieAdapter

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
        Intent(activity, DetailActivity::class.java).let {
            it.putExtra(DetailActivity.MOVIE,data.id)
            startActivity(it)
        }
    }

    private fun setupData() {
        val tvShows = tvShowViewModel.getTvShow()
        adapter = MovieAdapter(this)
        adapter.addList(tvShows)

        with(binding.rvTvShow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = this@TvShowFragment.adapter
        }
    }

}