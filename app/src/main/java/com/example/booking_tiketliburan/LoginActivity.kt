package com.example.booking_tiketliburan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var etNoHP: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvToRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etNoHP = findViewById(R.id.etNoHP)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvToRegister = findViewById(R.id.tvToRegister)

        btnLogin.setOnClickListener {
            val noHP = etNoHP.text.toString()
            val password = etPassword.text.toString()

            // Ambil data dari SharedPreferences
            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            val savedNoHP = sharedPref.getString("noHP", "")
            val savedPassword = sharedPref.getString("password", "")

            if (noHP == savedNoHP && password == savedPassword) {
                startActivity(Intent(this@LoginActivity, GalleryActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Nomor HP atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }

        tvToRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }
}
