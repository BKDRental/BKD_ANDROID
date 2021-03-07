package app.mimo.it.bkd.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.ActivityMainBinding
import app.mimo.it.bkd.feature.home.HomeFragment
import app.mimo.it.bkd.viewModel.MainViewModel
import app.mimo.it.core.extensions.openFragment
import app.mimo.it.core.utils.NetworkUtils
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val mViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.bottomNavigation.itemIconTintList = null
        openHomePage()
    }

    private fun openHomePage() {
        openFragment(
            fragment = HomeFragment.getInstance(),
            addToBackStack = true,
            isReplace = true,
            idContainer = R.id.nav_host_fragment
        )
    }

    protected fun onNetworkChange(block: (Boolean) -> Unit) {
        NetworkUtils.getNetworkStatus(this)
            .observe(this, { isConnected ->
                block(isConnected)
            })
    }

    companion object {
        fun getInstance(activity: AppCompatActivity) {
            activity.startActivity(Intent(activity, MainActivity::class.java))
        }
    }
}