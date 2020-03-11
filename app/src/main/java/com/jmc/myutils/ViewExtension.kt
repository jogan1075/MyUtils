package com.jmc.myutils

import android.view.View

/**
 * Created by Jmunoz on 09-03-20.
 */
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

