package org.tensorflow.lite.examples.classification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import org.json.JSONObject

class MainActivity2 : AppCompatActivity(), OnMapReadyCallback {



    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        crearFragmento()
        val bundle=intent.extras
        val dato=bundle?.getString("pais")
        val info=findViewById<TextView>(R.id.pais)
        info.text="El codigo del pais es: "+dato.toString()







    }

    private fun crearFragmento(){
        val mapFragment: SupportMapFragment=supportFragmentManager.
        findFragmentById(R.id.map)as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun crearPolylines(){
        val polyLineOptions= PolylineOptions()
            .add()
            .add(LatLng(36.81789309319866, -7.27250541741447))
            .add(LatLng(41.95346157258071, -6.5888768357322105))
            .add(LatLng(41.93034799915231, -8.810669726199555))
            .add(LatLng(37.190124399160844, -9.168021030260734))
            .add(LatLng(36.81789309319866, -7.27250541741447))

        val polyline=map.addPolyline(polyLineOptions)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map=googleMap
        crearPolylines()
        val place=LatLng(41.95346157258071, -6.5888768357322105)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(place,3f),
            100,null
        )

    }

}