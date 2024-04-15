package com.example.lisbonplaces

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONException

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id = intent.getIntExtra("id", 1)
        getDetail(id)
    }

    private fun getDetail(id: Int) {
        val url = resources.getString(R.string.url) + id + "/"
        val queue = Volley.newRequestQueue(this)
        val jsonObjectRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    val jresponse = response.getJSONObject(0)
                    val name = jresponse.getString("name")
                    val address = jresponse.getString("address")
                    val description = jresponse.getString("description")
                    val image = jresponse.getString("image")
                    val latitude = jresponse.getDouble("latitude")
                    val longitude = jresponse.getDouble("longitude")
                    val coordinates = "$latitude, $longitude"
                    val name_tv = findViewById<TextView>(R.id.name_tv)
                    name_tv.text = name
                    val address_tv = findViewById<TextView>(R.id.address_tv)
                    address_tv.text = address
                    val description_tv = findViewById<TextView>(R.id.description_tv)
                    description_tv.text = description
                    val coordinates_tv = findViewById<TextView>(R.id.coordinates_tv)
                    coordinates_tv.text = coordinates
                    val image_iv = findViewById<ImageView>(R.id.image_iv)
                    Glide.with(this@DetailActivity)
                        .load(image)
                        .into(image_iv)
                    msg(response.toString())
                } catch (je: JSONException) {
                    //
                }
            },
            {
                msg("That didn't work!")
            })
        queue.add(jsonObjectRequest)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun msg(txt: String) {
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show()
    }
}