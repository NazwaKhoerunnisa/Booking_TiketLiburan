package com.example.booking_tiketliburan

import android.os.Bundle
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GalleryActivity : AppCompatActivity() {
    private var gridView: GridView? = null
    private lateinit var tvWelcome: TextView
    private var images: IntArray = intArrayOf(
        R.drawable.g1,
        R.drawable.g2,
        R.drawable.g3,
        R.drawable.g4,
        R.drawable.g5,
        R.drawable.g6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        // Ambil nama dari SharedPreferences
        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
        val nama = sharedPref.getString("nama", "Pengguna")

        tvWelcome = findViewById(R.id.tvWelcome)
        tvWelcome.text = "Selamat datang, $nama!"

        gridView = findViewById(R.id.gridView)
        gridView?.adapter = ImageAdapter(this, images)
    }
}
