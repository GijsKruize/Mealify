package com.example.mealify

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.mealify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
            //val courseRV = findViewById<RecyclerView>(R.id.idProducts)

            // Here, we have created new array list and added data to it
            //val courseModelArrayList: ArrayList<ProductModel> = ArrayList<ProductModel>()
            //courseModelArrayList.add(ProductModel("DSA in Java", "a", R.drawable.banana))
            //courseModelArrayList.add(ProductModel("Java Course", "a", R.drawable.banana))
            //courseModelArrayList.add(ProductModel("C++ Course", "a", R.drawable.banana))
            //courseModelArrayList.add(ProductModel("DSA in C++", "a", R.drawable.banana))
            //courseModelArrayList.add(ProductModel("Kotlin for Android", "a", R.drawable.banana))
            //courseModelArrayList.add(ProductModel("Java for Android", "a", R.drawable.banana))
            //courseModelArrayList.add(ProductModel("HTML and CSS", "a", R.drawable.banana))

            // we are initializing our adapter class and passing our arraylist to it.
            //val courseAdapter = ProductAdapter(this, courseModelArrayList)

            // below line is for setting a layout manager for our recycler view.
            // here we are creating vertical list so we will provide orientation as vertical
            //val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            // in below two lines we are setting layoutmanager and adapter to our recycler view.
            //courseRV.layoutManager = linearLayoutManager
            //courseRV.adapter = courseAdapter

        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}

