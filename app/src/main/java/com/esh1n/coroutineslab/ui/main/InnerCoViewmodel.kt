package com.esh1n.coroutineslab.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class InnerCoViewmodel:BaseVM() {
    fun onRun() {
        testScope.launch {
            log("parent coroutine, start")

            launch {
                log("child coroutine, start")
                TimeUnit.MILLISECONDS.sleep(1000)
                log("child coroutine, end")
            }

            log("parent coroutine, end")
        }
    }

    fun onRunAndWait() {
        testScope.launch {
            log("parent coroutine, start")

            val job = launch {
                log("child coroutine, start")
                TimeUnit.MILLISECONDS.sleep(1000)
                log("child coroutine, end")
            }

            log("parent coroutine, wait until child completes")
            job.join()

            log("parent coroutine, end")
        }
    }
}