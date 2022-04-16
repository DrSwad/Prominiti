package com.example.prominiti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    private lateinit var splashLogo: ImageView
    private lateinit var splashTitle: TextView
    private lateinit var splashSlogan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_annimation)
        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        splashLogo = findViewById(R.id.splash_logo)
        splashTitle = findViewById(R.id.splash_title)
        splashSlogan = findViewById(R.id.splash_slogan)

        splashLogo.startAnimation(topAnimation)
        splashTitle.startAnimation(middleAnimation)
        splashSlogan.startAnimation(bottomAnimation)

        val splashScreenTimeOut = 2000
        val intent = Intent(this, Login::class.java)

        Handler().postDelayed({
            startActivity(intent)
            finish()
        },splashScreenTimeOut.toLong())
    }
}