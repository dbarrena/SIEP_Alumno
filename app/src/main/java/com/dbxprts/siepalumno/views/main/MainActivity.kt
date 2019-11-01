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
import androidx.lifecycle.Observer
import com.dbxprts.siepalumno.utils.PrefsKeys
import com.dbxprts.siepalumno.views.base.BaseActivity
import com.dbxprts.siepalumno.views.main.home.HomeFragment
import com.google.firebase.messaging.FirebaseMessaging
import com.jakewharton.threetenabp.AndroidThreeTen
import com.pixplicity.easyprefs.library.Prefs
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject


class MainActivity : BaseActivity<MainActivityViewModel>(MainActivityViewModel::class),
    HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(this)
        setAnimation()
        setContentView(R.layout.activity_main)

        init()
        observe()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Inicio"

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0)
        toggle.drawerArrowDrawable.color = resources.getColor(R.color.white)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        FirebaseMessaging.getInstance().subscribeToTopic("family_channel").addOnSuccessListener {
            Timber.d("subscribed to Hello topic")
        }

        setupNavigation()

    }

    private fun observe() {
        getStudents()

        viewModel.students.observe(this,
            Observer {
                it?.let { students ->

                }
            })
    }

    @Throws(Exception::class)
    private fun getStudents() {
        val familyID = Prefs.getLong(PrefsKeys.familyID, 0)

        if (familyID != 0L) {
            viewModel.getStudentsFromStudent(familyID)
        } else {
            throw Exception("Family ID doesn't exists.")
        }
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
