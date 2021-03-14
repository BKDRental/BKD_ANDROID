package app.mimo.it.bkd.feature.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentHomeBinding
import app.mimo.it.bkd.viewModel.HomeViewModel
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val mViewModel by viewModel<HomeViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.fragment = this
        mBinding.mViewModel = mViewModel
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }
}