package com.dbxprts.siepalumno.views.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.Transition
import androidx.appcompat.app.ActionBarDrawerToggle
import com.dbxprts.siepalumno.R
import com.dbxprts.siepalumno.views.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import androidx.fragment.app.Fragment
import com.dbxprts.siepalumno.views.main.home.HomeFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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

//        setupNavigation()
    }

    private fun setupNavigation() {
        loadFragment(HomeFragment.newInstance())
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment.newInstance())
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun setAnimation() {
        val fade = Fade()
        fade.addListener(object : Transition.TransitionListener {
            override fun onTransitionEnd(p0: Transition?) {
                setupNavigation()
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
        fade.duration = 500
        window.enterTransition = fade
    }

    override fun onBackPressed() {
        finish()
    }


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }
}
