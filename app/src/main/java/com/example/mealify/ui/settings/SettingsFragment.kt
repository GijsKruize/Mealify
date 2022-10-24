package com.example.mealify.ui.settings

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.os.ParcelFileDescriptor.open
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.mealify.R
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import java.io.*

class SettingsFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val captureUrl = "http://192.168.78.213/capture"
        //val captureUrl = "https://i.imgur.com/85wyR2x.jpg?fb" // Apple
        imageView = view.findViewById(R.id.captureImg)
        button = view.findViewById(R.id.captureBtn)

        try {
            button.setOnClickListener {
                try {
                    Glide.with(imageView.context)
                        .clear(imageView)
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
                try {
                    val glide = Glide.with(this@SettingsFragment.requireContext())
                        .asBitmap()
                        .load(captureUrl)
                        .apply(RequestOptions.skipMemoryCacheOf(true))
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    glide.into(imageView)
                } catch (e: Exception) {
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

    private fun initPython() {
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(requireContext()))
        }
    }

    private fun getPythonScript(): PyObject? {
        val python = Python.getInstance()
        val pythonFile = python.getModule("test")
        return pythonFile.callAttr("objectRecognition")
    }
}