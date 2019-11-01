package com.dbxprts.siepalumno.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dbxprts.siepalumno.R
import com.dbxprts.siepalumno.api.LoginService
import com.dbxprts.siepalumno.views.login.LoginActivity
import com.dbxprts.siepalumno.views.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    private var delayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 2000 //1 second
    private val PERMISSIONS_REQUEST = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        delayHandler = Handler()
        delayHandler!!.postDelayed(runnable, SPLASH_DELAY)
    }

    internal val runnable: Runnable = Runnable {
        /*if (!isFinishing) {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }*/
        initApp()
    }

    private fun initApp() {
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
//            intent = Intent(applicationContext, ServiceCompletedActivity::class.java)
//            crts.initialize(this)
//            crts.listener?.onStateUpdated("CRTS_START")
        } else {
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }
    }
}
