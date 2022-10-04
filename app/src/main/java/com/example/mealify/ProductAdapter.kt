package com.example.mealify

import ProductModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val context: Context, courseModelArrayList: ArrayList<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private val courseModelArrayList: ArrayList<ProductModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        // to inflate the layout for each item of recycler view.
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        // to set data to textview and imageview of each card layout
        val model: ProductModel = courseModelArrayList[position]
        holder.productName.setText(model.getProduct_name())
        holder.productDate.setText("" + model.getProduct_date())
        holder.productImage.setImageResource(model.getProduct_image())
    }

    override fun getItemCount(): Int {
        // this method is used for showing number of card items in recycler view.
        return courseModelArrayList.size
    }

    // View holder class for initializing of your views such as TextView and Imageview.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val productImage: ImageView
         val productName: TextView
         val productDate: TextView
        init {
            productImage = itemView.findViewById(R.id.idProductIamge)
            productName = itemView.findViewById(R.id.idProductName)
            productDate = itemView.findViewById(R.id.idProductDate)
        }
    }

    // Constructor
    init {
        this.courseModelArrayList = courseModelArrayList
    }
}
