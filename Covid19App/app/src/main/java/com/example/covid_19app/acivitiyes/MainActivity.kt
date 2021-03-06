package com.example.covid_19app.acivitiyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.covid_19app.R
import com.example.covid_19app.fragments.AboutFragment
import com.example.covid_19app.fragments.MapFragment
import com.example.covid_19app.fragments.NewsFragment
import com.example.covid_19app.fragments.StaticFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Covid19App)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val statsFragment = StaticFragment()
        val newsFragment = NewsFragment()
        val mapFragment = MapFragment()
        val aboutFragment = AboutFragment()
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.itemIconTintList = null

        makeCurrentFragment(statsFragment)

        bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId){
                R.id.ic_stat -> makeCurrentFragment(statsFragment)
                R.id.ic_news -> makeCurrentFragment(newsFragment)
                R.id.ic_map -> makeCurrentFragment(mapFragment)
                R.id.ic_info -> makeCurrentFragment(aboutFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}