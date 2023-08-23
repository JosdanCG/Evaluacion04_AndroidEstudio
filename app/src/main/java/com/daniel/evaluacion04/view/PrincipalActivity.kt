package com.daniel.evaluacion04.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.daniel.evaluacion04.R
import com.daniel.evaluacion04.databinding.ActivityMainBinding
import com.daniel.evaluacion04.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fcv_navigation) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvMenu.setupWithNavController(navController)
    }
}