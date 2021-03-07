package app.mimo.it.bkd.feature.home

import android.os.Bundle
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentHomeBinding
import app.mimo.it.bkd.viewModel.HomeViewModel
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val mViewModel by viewModel<HomeViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel

    companion object {
        fun getInstance(): HomeFragment = HomeFragment().apply {
            arguments = Bundle()
        }
    }
}