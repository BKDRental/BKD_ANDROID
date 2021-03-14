package app.mimo.it.bkd.feature.home.binding

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentManager
import app.mimo.it.bkd.viewModel.HomeViewModel
import app.mimo.it.core.extensions.hide
import app.mimo.it.core.extensions.show
import app.mimo.it.core.utils.DialogUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

object HomeBinding {
    @BindingAdapter(value = ["app:openCalendar", "app:mViewModel"], requireAll = false)
    @JvmStatic
    fun openCalendar(
        layout: ConstraintLayout,
        fragmentManager: FragmentManager?,
        mViewModel: HomeViewModel
    ) {
        fragmentManager?.let { manager ->
            layout.setOnClickListener {
                DialogUtils.dataPickerDialog(manager) { start, end ->
                    mViewModel.getDate(start, end)
                }
            }
        }
    }

    @BindingAdapter("app:show")
    @JvmStatic
    fun changeVisibility(view: View, visibility: StateFlow<Boolean>) {
        CoroutineScope(Dispatchers.Main).launch {
            visibility.collect {
                if (it) view.show()
                else view.hide()
            }
        }
    }

    @BindingAdapter("app:value")
    @JvmStatic
    fun setText(textView: TextView, text: StateFlow<CharSequence>) {
        CoroutineScope(Dispatchers.Main).launch {
            text.collect {
                textView.text = it
            }
        }
    }
}