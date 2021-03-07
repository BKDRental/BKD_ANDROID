package app.mimo.it.bkd.viewModel

import androidx.lifecycle.viewModelScope
import app.mimo.it.core.base.BaseViewModel
import app.mimo.it.core.utils.StateUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel : BaseViewModel() {
    private val _showNavigation: MutableStateFlow<StateUtils.NavigationState> =
        MutableStateFlow(StateUtils.NavigationState.InVisible)
    val showNavigation: StateFlow<StateUtils.NavigationState> get() = _showNavigation

    init {
        navigate()
    }

    private fun navigate() = viewModelScope.launch {
        delay(3000)
        _showNavigation.emit(StateUtils.NavigationState.Visible)
    }
}