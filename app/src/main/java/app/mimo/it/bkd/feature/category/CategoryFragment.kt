package app.mimo.it.bkd.feature.category

import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentCategoryBinding
import app.mimo.it.bkd.viewModel.CategoryViewModel
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {

    private val mViewModel by viewModel<CategoryViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel
}