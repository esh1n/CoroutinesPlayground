package com.esh1n.coroutineslab.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

class CancelViewModel : BaseVM() {


    override fun getTag() = CancelViewModel::class.java.simpleName.toString()

    lateinit var job: Job

     fun onRun() {
        log("onRun, start")

        job = testScope.launch {
            log("coroutine, start")
            var x = 0
            while (x < 5&& isActive) {
                delay(1000)
                log("coroutine, ${x++}, isActive = $isActive")
            }
            log("coroutine, end")
        }

        log("onRun, end")
    }

     fun onCancel() {
        log("onCancel")
        job.cancel()
    }

}