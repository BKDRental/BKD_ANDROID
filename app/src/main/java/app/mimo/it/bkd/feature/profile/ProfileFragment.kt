package app.mimo.it.bkd.feature.profile

import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentProfileBinding
import app.mimo.it.bkd.viewModel.ProfileViewModel
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    private val mViewModel by viewModel<ProfileViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel
}