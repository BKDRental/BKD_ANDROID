package app.mimo.it.bkd.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.ActivityMainBinding
import app.mimo.it.bkd.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val mViewModel by viewModel<MainViewModel>()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        configureNavController()
        mBinding.bottomNavigation.itemIconTintList = null
    }

    private fun configureNavController() {
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration.Builder().build()
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}