package app.mimo.it.bkd.feature.home

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentHomeBinding
import app.mimo.it.bkd.feature.home.adapter.CarListAdapter
import app.mimo.it.bkd.feature.home.adapter.CarTypeAdapter
import app.mimo.it.bkd.viewModel.HomeViewModel
import app.mimo.it.bkd.widget.CarouselLayoutManager
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import app.mimo.it.local.CarTypeModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val mViewModel by viewModel<HomeViewModel>()
    private var isSearch = false

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.fragment = this
        mBinding.mViewModel = mViewModel
        initListeners()
        initRecycler()
        initCarList()
    }

    private fun initListeners() {
        mBinding.containerSearch.setOnClickListener {
            if (!isSearch) startAnimate(R.anim.move_to_right)
            else startAnimate(R.anim.move_to_left)
        }
    }

    private fun startAnimate(animate: Int) {
        mBinding.labelSearch.apply {
            val anim = AnimationUtils.loadAnimation(context, animate)
            anim.fillAfter = true
            startAnimation(anim)
            isSearch = !isSearch
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    private fun initCarList() {
        mBinding.carList.adapter = CarListAdapter()
        mBinding.carList.isNestedScrollingEnabled = false
    }

    private fun initRecycler() {
        val list = ArrayList<CarTypeModel>()
        list.add(CarTypeModel(R.drawable.ic_1, "Adastra"))
        list.add(CarTypeModel(R.drawable.ic_1, "Beach Bum"))
        list.add(CarTypeModel(R.drawable.ic_1, "Dark Phoenix"))
        list.add(CarTypeModel(R.drawable.ic_1, "Glass"))
        list.add(CarTypeModel(R.drawable.ic_1, "Her Smell"))


        val adapter = CarTypeAdapter(list)

        mBinding.carTypeList.adapter = adapter
        mBinding.carTypeList.set3DItem(true)
        mBinding.carTypeList.setAlpha(true)
        val carouselLayoutManager = mBinding.carTypeList.getCarouselLayoutManager()
        val currentlyCenterPosition = mBinding.carTypeList.getSelectedPosition()

        mBinding.carTypeList.setItemSelectListener(object : CarouselLayoutManager.OnSelected {
            override fun onItemSelected(position: Int) {

            }
        })
    }
}