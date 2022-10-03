package com.example.mealify.data
import com.example.mealify.R
import com.example.mealify.model.Products

class ProductsData() {
    fun loadProducts(): List<Products> {
        return listOf<Products>(
            Products(R.string.product_milk, R.drawable.banana),
            Products(R.string.product_milk, R.drawable.banana),
            Products(R.string.product_milk, R.drawable.banana),
            Products(R.string.product_milk, R.drawable.banana),
            Products(R.string.product_milk, R.drawable.banana),
            Products(R.string.product_milk, R.drawable.banana),
            Products(R.string.product_milk, R.drawable.banana),
            Products(R.string.product_milk, R.drawable.banana),
        )
    }
}
