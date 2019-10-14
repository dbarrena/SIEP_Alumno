package com.dbxprts.siepalumno.extension

import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar


inline fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    val snackView = snack.view
    val snackText =
        snackView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
    snackText.maxLines = 10
    snack.show()
}

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    val snackView = snack.view
    val snackText =
        snackView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
    snackText.maxLines = 10
    snack.show()
}