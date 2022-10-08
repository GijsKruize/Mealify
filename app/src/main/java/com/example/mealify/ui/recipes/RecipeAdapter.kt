package com.example.mealify.ui.recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mealify.R

class RecipeAdapter(private val recipeList: ArrayList<Recipes>) :
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // to inflate the layout for each item of recycler view.
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recipe_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRecipe = recipeList[position]
        holder.recipeImage.setImageResource(currentRecipe.recipeImage)
        holder.recipeName.text = currentRecipe.recipeName
    }

    override fun getItemCount(): Int {
        // this method is used for showing number of card items in recycler view.
        return recipeList.size
    }

    // View holder class for initializing of your views such as TextView and Imageview.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeImage: ImageView = itemView.findViewById(R.id.idRecipeImage)
        val recipeName: TextView = itemView.findViewById(R.id.idRecipeName)
    }




}