package app.mimo.it.bkd.viewModel

import app.mimo.it.core.base.BaseViewModel
import app.mimo.it.core.utils.StateUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : BaseViewModel() {

    val _showNavigation: MutableStateFlow<StateUtils.NavigationState> =
        MutableStateFlow(StateUtils.NavigationState.InVisible)
    val showNavigation: StateFlow<StateUtils.NavigationState> get() = _showNavigation
}