package com.example.navigationdrawer

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity

import com.example.navigationdrawer.databinding.ActivityMainBinding
import com.example.navigationdrawer.ui.gallery.GalleryFragment
import com.example.navigationdrawer.ui.home.HomeFragment


class MainActivity : AppCompatActivity(){


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar);
        val toggle = ActionBarDrawerToggle(
                this,
        binding.drawerLayout,binding.toolbar,
        R.string.navigation_drawer_open,
        R.string.navigation_drawer_close
        )


        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportFragmentManager.beginTransaction()
            .replace(R.id.layFL, HomeFragment())
            .commitAllowingStateLoss()
        // Handle navigation item selection
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layFL, HomeFragment())
                        .commitAllowingStateLoss()
                  Toast.makeText(this@MainActivity,"Hi",Toast.LENGTH_LONG).show()
                }
                R.id.nav_gallery-> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layFL, GalleryFragment())
                        .commitAllowingStateLoss()
                    Toast.makeText(this@MainActivity,"Ga",Toast.LENGTH_LONG).show()
                }
                R.id.nav_slideshow -> {
                    // Handle Settings action
                }
            }
            binding.drawerLayout.closeDrawers() // Close the drawer after selection
            true
        }

    }


    }


