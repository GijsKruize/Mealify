package com.example.mealify.ui.recipes.descriptions

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.mealify.R
import org.w3c.dom.Text
import kotlin.properties.Delegates

class DescriptionsFragment : Fragment() {

    private lateinit var title: TextView
    private lateinit var image: ImageView
    private lateinit var description: TextView
    private lateinit var date: TextView
    private lateinit var ingredients: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v =  inflater.inflate(R.layout.fragment_descriptions, container, false)
        title = v.findViewById(R.id.recipeDescTitleID)
        image = v.findViewById(R.id.recipeDescImageID)
        description = v.findViewById(R.id.recipeDescDescID)
        date = v.findViewById(R.id.recipeDescDateID)
        ingredients = v.findViewById(R.id.recipeDescProductsID)

        //Receive the bundle send in RecipeAdapter
        var recipeName = arguments?.getString("recipeName")!!.toString()
        var recipeImage = arguments?.getInt("recipeImage")!!.toInt()
        var recipeDescription = arguments?.getString("recipeDesc")!!.toString()
        var recipeDate = arguments?.getString("recipeDate")!!.toString()
        var recipeIngredients = arguments?.getString("recipeIngredients")!!.toString()

        title.text = recipeName
        image.setImageResource(recipeImage)
        description.text = recipeDescription
        date.text = recipeDate
        ingredients.text = recipeIngredients
        return v
    }



}