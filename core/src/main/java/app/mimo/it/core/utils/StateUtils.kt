package app.mimo.it.core.utils

object StateUtils {

    sealed class UIState {
        object EMPTY : UIState()
        object SUCCESS : UIState()
        object LOADING : UIState()
        data class ERROR(var message: String) : UIState()
    }

    sealed class NavigationState {
        object Visible : NavigationState()
        object InVisible : NavigationState()
    }
}