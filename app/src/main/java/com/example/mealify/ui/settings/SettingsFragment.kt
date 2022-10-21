package com.example.mealify.ui.settings

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.example.mealify.R
import com.example.mealify.databinding.FragmentSettingsBinding
import com.example.mealify.gooogleVision.callAPI
import kotlinx.coroutines.*
import org.jsoup.parser.Tag
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.URL

class SettingsFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val captureUrl = "https://i.imgur.com/4HFRb2z.jpg"
        //val captureUrl = "http://192.168.178.66/capture" //AT HOME
        val captureUrl = "http://192.168.134.213/capture"

        imageView = view.findViewById(R.id.captureImg)
        button = view.findViewById(R.id.captureBtn)

        try {
            button.setOnClickListener {
                // var test : Array<String> = emptyArray()
                // callAPI(test)
                try {
                    Glide.with(imageView.context)
                        .clear(imageView)
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
                try {
                    Glide.with(this@SettingsFragment.requireContext())
                        .load(captureUrl)
                        .apply(RequestOptions.skipMemoryCacheOf(true))
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                        .into(imageView)
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            Glide.with(imageView.context).clear(imageView)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

    }

    private fun saveImage(image: Bitmap?): String? {
        var savedImagePath: String? = null
        val imageFileName = "JPEG_" + "IMAGE" + ".jpg"
        val storageDir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .toString() + "/ESP32"
        )
        var success = true
        if (!storageDir.exists()) {
            success = storageDir.mkdirs()
        }
        if (success) {
            val imageFile = File(storageDir, imageFileName)
            savedImagePath = imageFile.absolutePath
            try {
                val fOut: OutputStream = FileOutputStream(imageFile)
                image?.compress(Bitmap.CompressFormat.JPEG, 100, fOut)
                fOut.close()
            } catch (e : Exception) {
                e.printStackTrace()
            }
        }
        return savedImagePath
    }
}