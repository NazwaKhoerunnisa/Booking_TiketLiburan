package com.example.booking_tiketliburan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var etNama: EditText
    private lateinit var etNoHP: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNama = findViewById(R.id.etNama)
        etNoHP = findViewById(R.id.etNoHP)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val nama = etNama.text.toString()
            val noHP = etNoHP.text.toString()
            val password = etPassword.text.toString()

            if (nama.isNotEmpty() && noHP.isNotEmpty() && password.isNotEmpty()) {
                // Simpan data ke SharedPreferences
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("nama", nama)
                editor.putString("noHP", noHP)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Registrasi berhasil. Silakan login.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
