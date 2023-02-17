package com.example.myapplicationfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationfinal.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setContentView(binding.root)
        navController=this.findNavController(R.id.nav_host_fragment)
        appBarConfiguration= AppBarConfiguration(navController.graph)
    }
    override fun onNavigateUp(): Boolean {
        val navController = this.findNavController((R.id.nav_host_fragment))
        return navController.navigateUp()
    }
}