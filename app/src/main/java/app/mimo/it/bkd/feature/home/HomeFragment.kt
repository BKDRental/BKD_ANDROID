package app.mimo.it.bkd.feature.home

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentHomeBinding
import app.mimo.it.bkd.feature.home.adapter.CarListAdapter
import app.mimo.it.bkd.feature.home.adapter.CarTypeAdapter
import app.mimo.it.bkd.feature.home.adapter.LocationAdapter
import app.mimo.it.bkd.feature.home.adapter.TimeAdapter
import app.mimo.it.bkd.viewModel.HomeViewModel
import app.mimo.it.bkd.widget.CarouselLayoutManager
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import app.mimo.it.core.extensions.remove
import app.mimo.it.core.extensions.show
import app.mimo.it.local.CarTypeModel
import coil.load
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val mViewModel by viewModel<HomeViewModel>()
    private var isSearch = false
    private var isPickUpTime: Boolean = false
    private var isReturnTime: Boolean = false
    private var isPickUpLocation: Boolean = false
    private var isReturnLocation: Boolean = false
    private var isPickUpSelected = false
    private var isReturnSelected = false

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.fragment = this
        mBinding.mViewModel = mViewModel
        initListeners()
        initRecycler()
        initCarList()
        initTime()
        mBinding.containerPickUpTime.collapse()
        mBinding.containerReturnTime.collapse()
        mBinding.containerMapLocation.collapse()
        initLocationRecycler()
    }

    private fun initListeners() {
        mBinding.containerSearch.setOnClickListener {
            startAnimate(R.anim.move_to_right)
            lifecycleScope.launch {
                delay(1500)
                mViewModel.navigate(HomeFragmentDirections.homeFragmentToSearchFragment())
            }
        }
        mBinding.ImagePickUp.setOnClickListener {
            if (isPickUpTime) hidePickUpTime()
            else showPickUpTime()
        }
        mBinding.imageReturn.setOnClickListener {
            if (isReturnTime) hideReturnTime()
            else showReturnTime()
        }
        mBinding.layoutPickUpLocation.setOnClickListener {
            if (!isReturnSelected) {
                showLocationSheet()
            }
        }

        mBinding.layoutReturnLocation.setOnClickListener {
            if (!isPickUpSelected) {
                showLocation()
            }
        }
    }

    private fun showLocationSheet() {
        if (!isPickUpLocation) {
            isPickUpSelected = true
            mBinding.containerMapLocation.expand()
            mBinding.imagePickUpLocation.animate().rotation(180f).setDuration(500).start()
        } else {
            isPickUpSelected = false
            mBinding.containerMapLocation.collapse()
            mBinding.imagePickUpLocation.animate().rotation(0f).setDuration(500).start()
        }
        isPickUpLocation = !isPickUpLocation
    }

    private fun showLocation() {
        if (!isReturnLocation) {
            isReturnSelected = true
            mBinding.containerMapLocation.expand()
            mBinding.imageReturnLocation.animate().rotation(180f).setDuration(500).start()
        } else {
            isReturnSelected = false
            mBinding.containerMapLocation.collapse()
            mBinding.imageReturnLocation.animate().rotation(0f).setDuration(500).start()
        }
        isReturnLocation = !isReturnLocation
    }

    private fun startAnimate(animate: Int) {
        mBinding.labelSearch.apply {
            val anim = AnimationUtils.loadAnimation(context, animate)
            anim.fillAfter = true
            startAnimation(anim)
            isSearch = !isSearch
        }
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

    private fun showPickUpTime() {
        mBinding.ImagePickUp.load(R.drawable.ic_pick_up_time_default)
        isPickUpTime = true
        mBinding.containerPickUpTime.expand()
    }

    private fun hidePickUpTime() {
        mBinding.ImagePickUp.load(R.drawable.ic_pick_up_car)
        isPickUpTime = false
        mBinding.containerPickUpTime.collapse()
    }

    private fun showReturnTime() {
        mBinding.imageReturn.load(R.drawable.ic_return_car_default)
        isReturnTime = true
        mBinding.containerReturnTime.expand()
    }

    private fun hideReturnTime() {
        mBinding.imageReturn.load(R.drawable.ic_return_car)
        isReturnTime = false
        mBinding.containerReturnTime.collapse()
    }

    private fun initTime() {
        lifecycleScope.launch {
            mViewModel.pickUpTime.collect { data ->
                initTimeRecycler(mBinding.listPickUpTime, data, true)
                initTimeRecycler(mBinding.listReturnTime, data, false)
            }
        }
    }

    private fun initTimeRecycler(
        recyclerview: RecyclerView,
        data: List<String>,
        isPickUp: Boolean
    ) {
        recyclerview.apply {
            adapter = TimeAdapter(if (isPickUp) ::pickUpListener else ::returnListener).apply {
                updateData(data)
            }
        }
    }

    private fun pickUpListener(time: String) {
        hidePickUpTime()
        mBinding.textPickUp.remove()
        mBinding.textStartTime.show()
        mBinding.textStartTime.text = time
    }

    private fun returnListener(time: String) {
        hideReturnTime()
        mBinding.textReturnTime.remove()
        mBinding.textEndTime.show()
        mBinding.textEndTime.text = time
        mBinding.textUnderTime.show()
    }

    private fun initLocationRecycler() {
        mBinding.listLocation.apply {
            adapter = LocationAdapter(::selectLocation, ::openMap).apply {
                updateData(
                    mutableListOf(
                        getString(R.string.label_bkd_office),
                        getString(R.string.label_parking_1),
                        getString(R.string.label_parking_2)
                    )
                )
            }
        }
    }

    private fun openMap() {
        if (isPickUpSelected) {
            isPickUpSelected = !isPickUpSelected
            mBinding.imagePickUpLocation.animate().rotation(0f).setDuration(500).start()
            isPickUpLocation = !isPickUpLocation
        } else {
            isReturnSelected = !isReturnSelected
            mBinding.imageReturnLocation.animate().rotation(0f).setDuration(500).start()
            isReturnLocation = !isReturnLocation
        }
        mViewModel.navigate(HomeFragmentDirections.homeFragmentToMapFragment())
    }

    private fun selectLocation(name: String) {
        mBinding.containerMapLocation.collapse()
        if (isPickUpSelected) {
            mBinding.textPickUpLocation.text = name
            isPickUpSelected = !isPickUpSelected
            mBinding.imagePickUpLocation.animate().rotation(0f).setDuration(500).start()
            isPickUpLocation = !isPickUpLocation
        } else {
            isReturnSelected = !isReturnSelected
            mBinding.textReturnLocation.text = name
            mBinding.imageReturnLocation.animate().rotation(0f).setDuration(500).start()
            isReturnLocation = !isReturnLocation
        }
    }
}