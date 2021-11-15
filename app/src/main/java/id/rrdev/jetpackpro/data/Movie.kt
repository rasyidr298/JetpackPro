package id.rrdev.jetpackpro.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id : String?,
    val title : String?,
    val overview : String?,
    val genre : String?,
    val image : Int?,
    val dateOfRelease : String?,
    val duration : String?,
) : Parcelable