package app.mimo.it.bkd.feature.notification

import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentNotificationBinding
import app.mimo.it.bkd.viewModel.NotificationViewModel
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotificationFragment :
    BaseFragment<FragmentNotificationBinding>(R.layout.fragment_notification) {

    private val mViewModel by viewModel<NotificationViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel
}