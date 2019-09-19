package com.dbxprts.siepalumno.views.login

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.transition.Transition
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.dbxprts.siepalumno.R
import com.dbxprts.siepalumno.views.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnimation()
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init() {
        loginBtn.setOnClickListener {
            //            loginBtn.startAnimation()

            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent, options.toBundle())
        }

        password.setOnEditorActionListener { textView, i, keyEvent ->
            loginBtn.startAnimation()
            false
        }

    }

    private fun setAnimation() {
        val slide = Slide()
        slide.addListener(object : Transition.TransitionListener {
            override fun onTransitionEnd(p0: Transition?) {
                finishAffinity()
            }

            override fun onTransitionResume(p0: Transition?) {
            }

            override fun onTransitionPause(p0: Transition?) {
            }

            override fun onTransitionCancel(p0: Transition?) {
            }

            override fun onTransitionStart(p0: Transition?) {
            }

        })
        slide.duration = 500
        slide.slideEdge = Gravity.START
//        slide.interpolator = DecelerateInterpolator()
        window.exitTransition = slide
    }
}
