package id.rrdev.jetpackpro.ui.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.rrdev.jetpackpro.R
import id.rrdev.jetpackpro.ui.movie.MovieFragment
import id.rrdev.jetpackpro.ui.tvshow.TvShowFragment

class SectionsPagerAdapter(
    private val context: Context,
    fm : FragmentManager
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    companion object {
        @StringRes
        private val TAB_TITLE = intArrayOf(R.string.movieTitle, R.string.tvShowTitle)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLE[position])
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when(position) {
            0 -> MovieFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }

}