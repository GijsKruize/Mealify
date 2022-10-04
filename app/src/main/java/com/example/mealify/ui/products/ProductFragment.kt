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
import com.example.mealify.ProductAdapter
import com.example.mealify.R
import com.example.mealify.databinding.FragmentGalleryBinding

class ProductFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    private lateinit var adapter: ProductAdapter
    private lateinit var rv: RecyclerView
    private lateinit var productArrayList: ArrayList<Products>

    private lateinit var productImageID : Array<Int>
    lateinit var productName : Array<String>
    lateinit var productDate: Array<String>


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this)[ProductViewModel::class.java]

        _binding = FragmentGalleryBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        val recyclerView: ConstraintLayout = binding.productCardView
        galleryViewModel.text.observe(viewLifecycleOwner) {
            recyclerView.getViewById(id)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        rv = view.findViewById(R.id.idProducts)
        rv.layoutManager = layoutManager
        rv.setHasFixedSize(true)
        adapter = ProductAdapter(productArrayList)
        rv.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataInitialize(){
        productArrayList = arrayListOf<Products>()

        productImageID = arrayOf(
            R.drawable.banana,
            R.drawable.banana,
            R.drawable.banana,
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

        for (i in productImageID.indices) {
            val products = Products(productName[i],productDate[i] ,productImageID[i])
            productArrayList.add(products)
        }
    }
}