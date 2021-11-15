package id.rrdev.jetpackpro.utils

import id.rrdev.jetpackpro.data.Movie

interface OnItemClicked {
    fun onEventClick(data: Movie){}
}