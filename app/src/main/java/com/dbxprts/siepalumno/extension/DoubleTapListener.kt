package com.dbxprts.siepalumno.extension

import android.view.View

class DoubleTapListener(val listener: DoubleTapCallback) : View.OnClickListener {

    private var isRunning = false
    private val resetInTime = 500
    private var counter = 0

    override fun onClick(v: View) {

        if (isRunning) {
            if (counter == 1)
            //<-- makes sure that the callback is triggered on double click
                listener.onDoubleClick(v)
        }

        counter++

        if (!isRunning) {
            isRunning = true
            Thread(Runnable {
                try {
                    Thread.sleep(resetInTime.toLong())
                    isRunning = false
                    counter = 0
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }).start()
        }

    }

    interface DoubleTapCallback {

        fun onDoubleClick(v: View)
    }

}