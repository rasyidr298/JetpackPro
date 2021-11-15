package id.rrdev.jetpackpro.detail

import com.google.common.truth.Truth.assertThat
import id.rrdev.jetpackpro.ui.detail.DetailViewModel
import id.rrdev.jetpackpro.utils.MovieDummy
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = MovieDummy.getMovies()[0]
    private val movieId = dummyMovie.id

    @Before
    fun setup() {
        viewModel = DetailViewModel()
        movieId?.let { viewModel.setSelectedMovie(it) }
    }

    @Test
    fun `get the correct movie by movie id`() {
        dummyMovie.id?.let {
            viewModel.setSelectedMovie(it)
            val movieEntity = viewModel.getMovies()

            assertThat(movieEntity).isNotNull()
            assertThat(dummyMovie.id).isEqualTo(movieEntity.id)
            assertThat(dummyMovie.title).isEqualTo(movieEntity.title)
            assertThat(dummyMovie.overview).isEqualTo(movieEntity.overview)
            assertThat(dummyMovie.genre).isEqualTo(movieEntity.genre)
            assertThat(dummyMovie.image).isEqualTo(movieEntity.image)
            assertThat(dummyMovie.dateOfRelease).isEqualTo(movieEntity.dateOfRelease)
            assertThat(dummyMovie.duration).isEqualTo(movieEntity.duration)
        }

    }

}