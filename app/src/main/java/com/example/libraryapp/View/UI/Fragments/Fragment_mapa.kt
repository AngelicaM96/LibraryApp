package com.example.libraryapp.View.UI.Fragments

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.libraryapp.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.osmdroid.config.Configuration
import org.osmdroid.library.BuildConfig
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker


class Fragment_mapa : Fragment(), OnMapReadyCallback {

    lateinit var googleMap: GoogleMap

    lateinit var mapView: MapView

    //var _binding: FragmentMapaBinding?=null
    //val binding get()= _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_mapa, container, false)
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Identifica su aplicación de forma exclusiva para los servidores de mosaicos

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Google Maps
        val mapFragment= this.childFragmentManager.findFragmentById(R.id.mapa_nav) as SupportMapFragment
        mapFragment.getMapAsync(this)


        //Open Street Maps
        mapView= view.findViewById(R.id.mapOpenStreet)
        mapView.setTileSource(TileSourceFactory.MAPNIK);

        //Open Street Map Location
        val geoPoint= GeoPoint(2.9273, -75.28189)
        val mapController= mapView.controller
        mapController.setZoom(16.0)
        mapController.setCenter(geoPoint)

        //Marcador

        val marker= Marker(mapView)
        marker.setPosition(geoPoint)
        marker.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM)
        marker.setTitle("LibraryApp")
        mapView.overlays.add(marker)

    }

    override fun onMapReady(map: GoogleMap) {
        val colombia= LatLng(2.9273,-75.28189)
        map?.let {
            this.googleMap= it
            map.addMarker(MarkerOptions().position(colombia).title("LibraryApp Neiva"))
        }
        enableLocation()
    }

    companion object{
        const val REQUEST_CODE_LOCATION=0

    }

    fun isLocationPermissionGrated()= ContextCompat.checkSelfPermission(
        this.requireContext(),android.Manifest.permission.ACCESS_FINE_LOCATION
    )== PackageManager.PERMISSION_GRANTED

    fun requestLocationPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this.requireActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(this.context,"Activar permisos de ubicación",Toast.LENGTH_LONG).show()
        }else{
            ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                com.example.libraryapp.View.UI.Fragments.Fragment_mapa.Companion.REQUEST_CODE_LOCATION
            )
        }
    }

    @SuppressLint("MissingPermission")
    fun enableLocation(){
        if(!::googleMap.isInitialized)return
        if(isLocationPermissionGrated()){
            googleMap.isMyLocationEnabled=true
        }else{
            requestLocationPermission()
        }
    }


}