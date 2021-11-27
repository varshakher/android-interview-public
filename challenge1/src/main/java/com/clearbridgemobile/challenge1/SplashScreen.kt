package com.clearbridgemobile.challenge1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences


@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var sharedPreferences: SharedPreferences? = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        var firstTime: Boolean? = sharedPreferences?.getBoolean("firstTime", true);
        if (firstTime == true) {
            // This is used to hide the status bar and make
            // the splash screen as a full screen activity.
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )

            // we used the postDelayed(Runnable, time) method
            // to send a message with a delayed time.
            Handler().postDelayed({

                val editor = sharedPreferences!!.edit()
                firstTime = false
                editor.putBoolean("firstTime", firstTime!!)
                editor.apply()
                val intent = Intent(this, WelcomeScreen::class.java)
                startActivity(intent)
                finish()
            }, 3000) // 3000 is the delayed time in milliseconds.
        } else {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}