package com.example.lisbonplaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.lisbonplaces.databinding.ActivityMapsBinding
import org.json.JSONException

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val point = LatLng(38.73240225798916, -9.160349629389367)
//        mMap.addMarker(MarkerOptions().position(point).title("NovaIms"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(point))
        getPlaces()
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 11f))
        mMap.setOnInfoWindowClickListener { marker ->
            val i = Intent(this@MapsActivity, DetailActivity::class.java)
            val id = marker.tag as Int
            i.putExtra("id", id)
            startActivity(i)
        }
    }

    private fun getPlaces() {
        val url = resources.getString(R.string.url)
        val queue = Volley.newRequestQueue(this)
        val jsonObjectRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    for (i in 0 until response.length()) {
                        val jresponse = response.getJSONObject(i)
                        val id = jresponse.getInt("id")
                        val name = jresponse.getString("name")
                        val address = jresponse.getString("address")
                        val latitude = jresponse.getDouble("latitude")
                        val longitude = jresponse.getDouble("longitude")
                        val marker = mMap.addMarker(
                            MarkerOptions()
                                .position(LatLng(latitude, longitude))
                                .title(name)
                                .snippet(address)
                        )
                        marker?.tag = id
                    }
                    msg(response.toString())
                } catch (je: JSONException) {
                    //
                }
            },
            { error ->
                // TODO: Handle error
                msg("That didn't work! \n$error")
            }
        )
        queue.add(jsonObjectRequest)
    }

    private fun msg(txt: String) {
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show()
    }
}