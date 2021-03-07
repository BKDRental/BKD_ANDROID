package app.mimo.it.bkd.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import app.mimo.it.bkd.databinding.ActivitySplashBinding
import app.mimo.it.bkd.main.MainActivity
import app.mimo.it.bkd.viewModel.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySplashBinding
    private val mViewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        navigate()
    }

    private fun navigate() {
        lifecycleScope.launch {
            delay(3000L)
            MainActivity.getInstance(this@SplashActivity)
        }
    }
}