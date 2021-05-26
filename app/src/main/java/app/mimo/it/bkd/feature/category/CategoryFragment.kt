package app.mimo.it.bkd.feature.category

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentCategoryBinding
import app.mimo.it.bkd.feature.category.adapter.CategoryAdapter
import app.mimo.it.bkd.viewModel.CategoryViewModel
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {

    private val mViewModel by viewModel<CategoryViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        mBinding.list1.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mBinding.list1.adapter = CategoryAdapter().apply {
            setData(mViewModel.getData())
        }

        mBinding.list2.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mBinding.list2.adapter = CategoryAdapter().apply {
            setData(mViewModel.getData())
        }

        mBinding.list3.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mBinding.list3.adapter = CategoryAdapter().apply {
            setData(mViewModel.getData())
        }
    }
}