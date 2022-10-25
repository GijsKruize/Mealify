package com.example.mealify.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mealify.R

class ProductAdapter(private val productList: ArrayList<Products>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    //private val courseModelArrayList: ArrayList<Products>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // to inflate the layout for each item of recycler view.
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // to set data to textview and imageview of each card layout
        val currentProduct = productList[position]
        holder.productImage.setImageResource(currentProduct.productImage)
        holder.productName.text = currentProduct.productName

        //Commented out for now
        //val model: ProductModel = courseModelArrayList[position]
        //holder.productName.text = model.getProduct_name()
        //holder.productDate.text = "" + model.getProduct_date()
        //holder.productImage.setImageResource(model.getProduct_image())
    }

    override fun getItemCount(): Int {
        // this method is used for showing number of card items in recycler view.
        return productList.size
    }

    // View holder class for initializing of your views such as TextView and Imageview.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val productImage: ImageView = itemView.findViewById(R.id.idProductImage)
         val productName: TextView = itemView.findViewById(R.id.idProductName)
    }
}
