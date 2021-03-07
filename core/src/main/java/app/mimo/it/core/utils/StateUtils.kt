package app.mimo.it.core.utils

object StateUtils {

    sealed class LoginUIState {
        object EMPTY : LoginUIState()
        object SUCCESS : LoginUIState()
        object LOADING : LoginUIState()
        data class ERROR(var message: String) : LoginUIState()
    }

    sealed class NavigationState {
        object Visible : NavigationState()
        object InVisible : NavigationState()
    }
}