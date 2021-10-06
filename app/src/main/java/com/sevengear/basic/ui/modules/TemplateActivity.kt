package com.sevengear.basic.ui.modules

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.sevengear.basic.BuildConfig
import com.sevengear.basic.R

abstract class TemplateActivity(private val graphResId: Int, layout: Int) : AppCompatActivity(layout), TemplateView {
    private val navController by lazy {
        // As per an issue in library (version 2.2.1), when using FragmentContainerView, we need to
        // find the NavController using findFragmentById() rather than using findNavController()
        (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!BuildConfig.DEBUG) {
            window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        }
        initGraph()
    }

    private fun initGraph() {
        navController.setGraph(graphResId)
    }
}