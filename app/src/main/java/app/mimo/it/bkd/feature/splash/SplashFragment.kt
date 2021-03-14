package app.mimo.it.bkd.feature.splash

import androidx.appcompat.app.AppCompatActivity
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentSplashBinding
import app.mimo.it.bkd.viewModel.SplashViewModel
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private val mViewModel by viewModel<SplashViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }
}