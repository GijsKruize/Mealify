package com.example.mealify.ui.recipes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mealify.R
import com.example.mealify.ui.recipes.descriptions.DescriptionsFragment

class RecipeAdapter(private val recipeList: ArrayList<Recipes>) :
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // to inflate the layout for each item of recycler view.
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.recipe_card, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRecipe = recipeList[position]
        holder.recipeImage.setImageResource(currentRecipe.recipeImage)
        holder.recipeName.text = currentRecipe.recipeName
        //holder.recipeDescription.text = currentRecipe.recipeDescription

        //OnClickListener to go from recipe list to description of recipe
        holder.itemView.setOnClickListener { v ->

            //Create the context
            val activity = v!!.context as AppCompatActivity
            val descriptionsFragment = DescriptionsFragment()

            //Create a bundle of data to be sent
            val bundle = Bundle()
            bundle.putString("recipeName", currentRecipe.recipeName)
            bundle.putInt("recipeImage", currentRecipe.recipeImage)
            bundle.putString("recipeDesc", currentRecipe.recipeDescription)
            descriptionsFragment.arguments = bundle

            //Change the RecipeFragment to DescriptionFragment
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.recipe_card_view, descriptionsFragment).addToBackStack(null).commit()
        }
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