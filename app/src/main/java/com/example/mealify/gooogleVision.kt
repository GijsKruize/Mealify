package com.example.mealify

import com.google.cloud.vision.v1.AnnotateImageRequest
import com.google.cloud.vision.v1.Feature
import com.google.cloud.vision.v1.Feature.Type
import com.google.cloud.vision.v1.Image
import com.google.cloud.vision.v1.ImageAnnotatorClient
import com.google.protobuf.ByteString

import java.io.IOException
import java.io.File

object gooogleVision {
    fun callAPI(args: Array<String>) {
        val imageFileName = if (args.isEmpty()) {
            "./res/drawable/test.jpg" // Image file path
        } else {
            args[0] // grab args[0] for file
        }

        val imageFile = File(imageFileName)
        if (!imageFile.exists()) {
            throw NoSuchFileException(
                file = imageFile,
                reason = "The file you specified does not exist"
            )
        }

        try {
            quickstart(imageFileName)
        } catch (e: IOException) {
            println("Image annotation failed:")
            println(e.message)
        }
    }

    fun quickstart(imageFileName: String) {
        val imgProto = ByteString.copyFrom(File(imageFileName).readBytes())
        val vision = ImageAnnotatorClient.create()

        // Set up the Cloud Vision API request.
        val img = Image.newBuilder().setContent(imgProto).build()
        val feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build()
        val request = AnnotateImageRequest.newBuilder()
            .addFeatures(feat)
            .setImage(img)
            .build()

        // Call the Cloud Vision API and perform label detection on the image.
        val result = vision.batchAnnotateImages(arrayListOf(request))

        // Print the label annotations for the first response.
        result.responsesList[0].labelAnnotationsList.forEach { label ->
            println("${label.description} (${(label.score * 100).toInt()}%)")
        }
        // [END vision_quickstart]
    }
}
