package com.esh1n.coroutineslab.ui.main

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class LazyCoVM:BaseVM() {

    private lateinit var job:Job

    fun onPrepareLazyRun(){
        log("onRun, start")

        job = testScope.launch(start = CoroutineStart.LAZY) {
            log("coroutine, start")
            TimeUnit.MILLISECONDS.sleep(1000)
            log("coroutine, end")
        }

        log("onRun, end")
    }

    fun onRunLazy(){
        log("onRun2, start")
        job.start()
        log("onRun2, end")
    }

    override fun getTag() = "LazyCoVM"
}