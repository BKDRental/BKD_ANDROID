package app.mimo.it.core.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import app.mimo.it.core.Event
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackBar(snackBarText: String, timeLength: Int) {
    activity?.let {
        Snackbar.make(it.findViewById(android.R.id.content), snackBarText, timeLength).show()
    }
}

fun Fragment.setupSnackBar(
    lifecycleOwner: LifecycleOwner,
    snackBarEvent: LiveData<Event<Any>>,
    timeLength: Int
) {
    snackBarEvent.observe(lifecycleOwner, { event ->
        event.getContentIfNotHandled()?.let { res ->
            context?.let { showSnackBar("$res", timeLength) }
        }
    })
}