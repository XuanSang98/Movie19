package com.sunasterisk.movie19.ui.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.ui.main.MainActivity

class SplashScreen : AppCompatActivity() {

    private val TIME = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler().postDelayed({
            startActivity(MainActivity.getIntent(this))
            finish()
        }, TIME)
    }
}
