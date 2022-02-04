package com.moizaandroid.moiza.ui.component.main


import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.ActivityMainBinding
import com.moizaandroid.moiza.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun init() {
        initBottomNavBar()
    }


    private fun initBottomNavBar() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.fragment_view)?.findNavController()
        val nav = binding.bottomNav as BottomNavigationView
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }
}