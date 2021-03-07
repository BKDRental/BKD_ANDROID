package app.mimo.it.bkd.feature.splash

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentSplashBinding
import app.mimo.it.bkd.viewModel.SplashViewModel
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private val mViewModel by viewModel<SplashViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.window?.decorView?.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun getViewModel(): BaseViewModel = mViewModel
}