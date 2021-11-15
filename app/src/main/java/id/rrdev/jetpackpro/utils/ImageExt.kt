package id.rrdev.jetpackpro.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

fun ImageView.load(image : Any?) {
    Glide.with(context.applicationContext)
        .load(image)
        .transition(DrawableTransitionOptions.withCrossFade(getDrawableFactory()))
        .into(this)
}

private fun getDrawableFactory() : DrawableCrossFadeFactory {
    return DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
}