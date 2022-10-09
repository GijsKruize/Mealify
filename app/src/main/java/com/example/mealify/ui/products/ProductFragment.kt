package com.example.mealify.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealify.R
import com.example.mealify.databinding.FragmentProductBinding

class ProductFragment : Fragment() {

    private lateinit var adapter: ProductAdapter
    private lateinit var rv: RecyclerView
    private lateinit var productArrayList: ArrayList<Products>

    private lateinit var productImageID : Array<Int>
    lateinit var productName : Array<String>
    lateinit var productDate: Array<String>


    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    // This method starts as the view is created (products tab is opened)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize the data to be displayed in the cards in the recyclerview
        dataInitialize()

        // Create a layout manager and assign it (and the adapter made in ProductAdapter) to the recyclerview
        val layoutManager = LinearLayoutManager(context)
        rv = view.findViewById(R.id.idProducts)
        rv.layoutManager = layoutManager
        rv.setHasFixedSize(true)
        adapter = ProductAdapter(productArrayList)
        rv.adapter = adapter
    }

    // Initialize the data to be displayed in the cards
    private fun dataInitialize(){
        productArrayList = arrayListOf<Products>()

        productImageID = arrayOf(
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.steak,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana
        )
        productDate = arrayOf(
            "date",
            "date",
            "date",
            "date",
            "date",
            "date",
            "date"
        )
        productName = arrayOf(
            "name",
            "name",
            "name",
            "name",
            "name",
            "name",
            "name"
        )


        // Set the above initialized data to the correct place
        for (i in productImageID.indices) {
            val products = Products(productName[i],productDate[i] ,productImageID[i])
            productArrayList.add(products)
        }
    }
}