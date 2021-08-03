package com.example.a4kwalpapers

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
import com.example.a4kwalpapers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
      //  navView.itemIconTintList = null
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

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->{
                    navController.navigate(R.id.nav_home)
                    binding.navView.menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home_2)
                    binding.navView.menu.findItem(R.id.nav_gallery).setIcon(R.drawable.ic_bookmark)
                    binding.navView.menu.findItem(R.id.nav_slideshow).setIcon(R.drawable.ic_settings)
                    binding.drawerLayout.close()
                }
                R.id.nav_gallery->{
                    navController.navigate(R.id.nav_gallery)
                    binding.navView.menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home)
                    binding.navView.menu.findItem(R.id.nav_gallery).setIcon(R.drawable.ic_bookmark_2)
                    binding.navView.menu.findItem(R.id.nav_slideshow).setIcon(R.drawable.ic_settings)
                    binding.drawerLayout.close()
                }
                R.id.nav_slideshow->{
                    navController.navigate(R.id.nav_slideshow)
                    binding.navView.menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home)
                    binding.navView.menu.findItem(R.id.nav_gallery).setIcon(R.drawable.ic_bookmark)
                    binding.navView.menu.findItem(R.id.nav_slideshow).setIcon(R.drawable.ic_settings_2)
                    binding.drawerLayout.close()
                }
            }
            true
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}