package com.dbxprts.siepalumno.views.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import androidx.appcompat.app.ActionBarDrawerToggle
import com.dbxprts.siepalumno.R
import com.dbxprts.siepalumno.views.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnimation()
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Inicio"

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0)
        toggle.drawerArrowDrawable.color = resources.getColor(R.color.white)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setAnimation() {
        val fade = Fade()
        fade.duration = 500
        window.enterTransition = fade
    }
}
