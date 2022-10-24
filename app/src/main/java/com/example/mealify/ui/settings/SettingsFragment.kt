package com.example.mealify.ui.settings

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
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
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.mealify.R
import com.example.mealify.databinding.FragmentSettingsBinding
import com.example.mealify.gooogleVision.callAPI
import kotlinx.coroutines.*
import org.jsoup.parser.Tag
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.URL

class SettingsFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var button: Button

    var imageString = ""

    var count = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initPython()
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val captureUrl = "https://i.imgur.com/4HFRb2z.jpg"
        //val captureUrl = "http://192.168.178.66/capture" //AT HOME
        //val captureUrl = "http://192.168.134.213/capture"
        val captureUrl = "https://i.imgur.com/85wyR2x.jpg?fb" // Apple
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
                try {
                    if (count > 0) {
                        var drawable = imageView.drawable as? BitmapDrawable
                        var bitmap = drawable?.bitmap
                        imageString = getStringImage(bitmap)
                        getPythonScript()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                count += 1
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

    private fun getStringImage(bitmap: Bitmap?): String {
        val baos = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val imageBytes = baos.toByteArray()
        return android.util.Base64.encodeToString(imageBytes, 0)
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