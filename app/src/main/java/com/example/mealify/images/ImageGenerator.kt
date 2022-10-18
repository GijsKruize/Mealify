package com.example.mealify.images

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream
import java.net.URL

object ImageGenerator {
    private fun getWebImage(url_input: String): Bitmap? {
        val url = URL(url_input)
        return BitmapFactory.decodeStream(url.openConnection().getInputStream())
    }
}