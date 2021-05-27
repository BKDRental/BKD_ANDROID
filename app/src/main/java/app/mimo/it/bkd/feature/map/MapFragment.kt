package app.mimo.it.bkd.feature.map

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import androidx.core.app.ActivityCompat
import app.mimo.it.bkd.R
import app.mimo.it.bkd.databinding.FragmentMapBinding
import app.mimo.it.bkd.viewModel.MapViewModel
import app.mimo.it.core.base.BaseFragment
import app.mimo.it.core.base.BaseViewModel
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapFragment : BaseFragment<FragmentMapBinding>(R.layout.fragment_map),
    OnMapReadyCallback {

    private val mViewModel by viewModel<MapViewModel>()

    private var supportMapFragment: SupportMapFragment? = null
    private var fusedLocationProviderClient: FusedLocationProviderClient? = null
    private var currentLocation: Location? = null
    private var mMap: GoogleMap? = null
    private var locationRequest: LocationRequest? = null
    private var locationCallback: LocationCallback? = null

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        supportMapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        supportMapFragment?.getMapAsync(this)
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            getCurrentLocation()
        } else {
            requestPermissions(
                Array(1) { android.Manifest.permission.ACCESS_FINE_LOCATION }, 1
            )
        }
        initListeners()
    }

    override fun onMapReady(google: GoogleMap?) {
        google?.let { googleMap ->
            mMap = googleMap
        }
    }

    @SuppressLint("MissingPermission")
    private fun locationRequest() {
        locationRequest = LocationRequest.create()
        locationRequest?.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest?.interval = 20 * 1000
        locationCallback = object : LocationCallback() {
            @SuppressLint("MissingPermission")
            override fun onLocationResult(location: LocationResult?) {
                if (location == null) {
                    return
                }
                location.locations.forEach {
                    it?.let { location ->
                        mMap?.isMyLocationEnabled = true
                        currentLocation = location
                    }
                }
            }
        }
        fusedLocationProviderClient?.requestLocationUpdates(
            locationRequest!!,
            locationCallback!!,
            Looper.getMainLooper()
        )
    }

    @SuppressLint("MissingPermission")
    private fun fetchLastLocation() {
        val task = fusedLocationProviderClient?.lastLocation
        task?.addOnSuccessListener {
            if (it == null) {
                locationRequest()
            } else {
                it.let { location ->
                    currentLocation = location
                    mMap?.animateCamera(
                        CameraUpdateFactory.newLatLngZoom(
                            LatLng(
                                location.latitude,
                                location.longitude
                            ), 12f
                        )
                    )
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getCurrentLocation() {
        val task = fusedLocationProviderClient?.lastLocation
        task?.addOnSuccessListener {
            if (it == null) {
                locationRequest()
            } else {
                it.let { location ->
                    mMap?.isMyLocationEnabled = true
                    currentLocation = location
                    mMap?.animateCamera(
                        CameraUpdateFactory.newLatLngZoom(
                            LatLng(
                                location.latitude,
                                location.longitude
                            ), 12f
                        )
                    )
                    supportMapFragment?.getMapAsync(this)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            1 -> {
                if (checkPermission(grantResults)) {
                    getCurrentLocation()

                }
            }
        }
    }

    private fun checkPermission(grantResults: IntArray) =
        grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED


    private fun initListeners() {
        mBinding.actionCurrentLocation.setOnClickListener {
            fetchLastLocation()
        }
    }
}