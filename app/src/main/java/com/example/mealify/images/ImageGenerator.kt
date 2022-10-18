package com.example.mealify.images

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream
import java.net.URL

object ImageGenerator {
    private val bitmapArray = ArrayList<Bitmap>()

    private fun addWebImage(url_input: String) {
        val url = URL(url_input)
        val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        bitmapArray.add(bitmap)
    }
}