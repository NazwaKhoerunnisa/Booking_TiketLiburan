package com.example.booking_tiketliburan

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.booking_tiketliburan.R
import com.example.booking_tiketliburan.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            finish()
        }, 3000)
    }
}
