package com.dbxprts.siepalumno.views.login

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.transition.Transition
import android.view.Gravity
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dbxprts.siepalumno.R
import com.dbxprts.siepalumno.extension.snack
import com.dbxprts.siepalumno.views.base.BaseActivity
import com.dbxprts.siepalumno.views.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.content
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : BaseActivity<LoginActivityViewModel>(LoginActivityViewModel::class) {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setAnimation()
        setContentView(R.layout.activity_login)

        init()
        observe()
    }

    private fun init() {
        mAuth = FirebaseAuth.getInstance()

        loginBtn.setOnClickListener {
            loginBtn.startAnimation()
            login()
        }

        password.setOnEditorActionListener { textView, i, keyEvent ->
            loginBtn.startAnimation()
            login()
            false
        }

    }

    private fun observe() {
        viewModel.userAuthenticated.observe(this,
            Observer {
                it?.let {
                    if (it) {
                        val options = ActivityOptions.makeSceneTransitionAnimation(this)
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent, options.toBundle())
                    }
                }
            })

        viewModel.messages.observe(this,
            Observer {
                it?.let {
                    content.snack(it, Snackbar.LENGTH_SHORT)
                }
            }
        )
    }

    private fun login() {
        if (email.text.toString().isNotEmpty() || password.text.toString().isNotEmpty()) {
            mAuth?.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                ?.addOnCompleteListener {
                    if (it.isSuccessful) {
//                    viewModel.getShopperProperties()
                    } else {
                        loginBtn.revertAnimation()
                        content.snack(
                            "Los datos son incorrectos, por favor intenta de nuevo.",
                            Snackbar.LENGTH_SHORT
                        )
                    }
                }
        } else {
            loginBtn.revertAnimation()
            content.snack("Por favor ingresa los datos necesarios.", Snackbar.LENGTH_SHORT)
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
