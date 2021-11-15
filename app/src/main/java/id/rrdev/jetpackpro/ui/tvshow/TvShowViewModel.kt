package id.rrdev.jetpackpro.ui.tvshow

import androidx.lifecycle.ViewModel
import id.rrdev.jetpackpro.utils.MovieDummy

class TvShowViewModel : ViewModel() {
    fun getTvShow() = MovieDummy.getTvShow()
}