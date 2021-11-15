package id.rrdev.jetpackpro.movie


import com.google.common.truth.Truth.assertThat
import id.rrdev.jetpackpro.ui.movie.MovieViewModel
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setup() {
        viewModel = MovieViewModel()
    }

    @Test
    fun `get movies from dummy movies returns sucess`() {
        val movie = viewModel.getDummyMovies()

        assertThat(movie).isNotNull()
        assertThat(movie.size).isEqualTo(10)
    }

}