package com.jmc.myutils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget

/**
 * Created by Jmunoz on 09-03-20.
 */
object GlideUtils {
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).centerCrop().into(imageView)
    }

    fun loadImageFitCenter(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).fitCenter().into(imageView)
    }

    /*
        Cuando un fragmento o actividad pierde el foco o se destruye, Glide automáticamente dejará de cargar recursos relacionados para garantizar que los recursos no se desperdicien
     */
    fun loadUrlImage(context: Context, url: String, imageView: ImageView){
        Glide.with(context).load(url).placeholder(R.drawable.icon_back).error(R.drawable.icon_back).centerCrop().into(
            object : SimpleTarget<GlideDrawable>() {
                override fun onResourceReady(resource: GlideDrawable,
                                             glideAnimation: GlideAnimation<in GlideDrawable>) {
                    imageView.setImageDrawable(resource)
                }
            })
    }
}