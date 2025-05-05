package com.example.booking_tiketliburan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ImageAdapter(private val context: Context, private val images: IntArray) : BaseAdapter() {

    private val namaTempat = arrayOf(
        "Pantai Labuan Bajo",
        "Gunung Rinjani",
        "Taman Mini Indonesia Indah",
        "Raja Ampat",
        "Candi Borobudur",
        "Dataran Tinggi Dieng"
    )

    private val hargaTempat = arrayOf(
        "Rp 350.000",
        "Rp 500.000",
        "Rp 100.000",
        "Rp 1.200.000",
        "Rp 150.000",
        "Rp 200.000"
    )

    override fun getCount(): Int = images.size
    override fun getItem(position: Int): Any = images[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val tvNama = view.findViewById<TextView>(R.id.tvNama)
        val tvHarga = view.findViewById<TextView>(R.id.tvHarga)

        imageView.setImageResource(images[position])
        tvNama.text = namaTempat[position]
        tvHarga.text = hargaTempat[position]

        return view
    }
}
