package app.mimo.it.bkd.viewModel

import androidx.lifecycle.viewModelScope
import app.mimo.it.bkd.feature.splash.SplashFragmentDirections
import app.mimo.it.core.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : BaseViewModel() {

    init {
        navigate()
    }

    private fun navigate() = viewModelScope.launch {
        delay(3000L)
        navigate(SplashFragmentDirections.splashFragmentToHomeFragment())
    }
}