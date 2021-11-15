package id.rrdev.jetpackpro.tv_show

import com.google.common.truth.Truth.assertThat
import id.rrdev.jetpackpro.ui.tvshow.TvShowViewModel
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setup() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun `get all tv show data and returns success`() {
        val tvShows = viewModel.getTvShow()

        assertThat(tvShows).isNotNull()
        assertThat(tvShows.size).isEqualTo(10)
    }

}