package com.example.mealify.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealify.ProductAdapter
import com.example.mealify.R
import com.example.mealify.RecipeAdapter
import com.example.mealify.databinding.FragmentHomeBinding
import com.example.mealify.ui.products.Products

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var adapter: RecipeAdapter
    private lateinit var rv: RecyclerView
    private lateinit var recipeArrayList: ArrayList<Recipes>

    private lateinit var recipeImageID : Array<Int>
    lateinit var recipeName : Array<String>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerViewRecipes: ConstraintLayout = binding.recipeCardView
        homeViewModel.text.observe(viewLifecycleOwner) {
            recyclerViewRecipes.getViewById(id)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize the data to be displayed in the cards in the recyclerview
        recipeInitialize()

        // Create a layout manager and assign it (and the adapter made in ProductAdapter) to the recyclerview
        val layoutManager = LinearLayoutManager(context)
        rv = view.findViewById(R.id.idRecipes)
        rv.layoutManager = layoutManager
        rv.setHasFixedSize(true)
        adapter = RecipeAdapter(recipeArrayList)
        rv.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun recipeInitialize(){
        recipeArrayList = arrayListOf<Recipes>()

        recipeImageID = arrayOf(
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana
        )
        recipeName = arrayOf(
            "name",
            "name",
            "name",
            "name",
            "name",
            "name",
            "name"
        )


        // Set the above initialized data to the correct place
        for (i in recipeImageID.indices) {
            val recipes = Recipes(recipeName[i], recipeImageID[i])
            recipeArrayList.add(recipes)
        }
    }
}