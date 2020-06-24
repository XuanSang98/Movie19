package com.sunasterisk.movie19.ui.main

import android.content.Context
import android.content.Intent
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override val layoutId get() = R.layout.activity_main

    private val navHostFragment: NavHostFragment? by lazy {
        supportFragmentManager.findFragmentById(R.id.fragmentMain) as NavHostFragment?
    }

    override fun initComponents() {
        navHostFragment?.let {
            NavigationUI.setupWithNavController(
                bottomNavigationView,
                it.navController
            )
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
