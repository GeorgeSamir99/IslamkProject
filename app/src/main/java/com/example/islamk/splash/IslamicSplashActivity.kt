package com.example.islamk.splash

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islamk.R
import com.example.islamk.home.HomeActivity

class IslamicSplashActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_islamic_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.insetsController?.hide(WindowInsets.Type.statusBars())

        Handler(Looper.getMainLooper()).postDelayed({
            navigateToHomeActivity()
        },2000)
    }

    private fun navigateToHomeActivity() {

        startActivity(Intent(this@IslamicSplashActivity,HomeActivity::class.java))
        finish()

    }

}