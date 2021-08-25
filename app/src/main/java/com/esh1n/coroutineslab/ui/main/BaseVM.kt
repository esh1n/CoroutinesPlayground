package com.esh1n.coroutineslab.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import java.text.SimpleDateFormat
import java.util.*

open class BaseVM: ViewModel() {

    private var formatter = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())

    protected val testScope = CoroutineScope(Job())

    open fun getTag():String = BaseVM::class.simpleName.toString()

    fun log(text: String) {
        Log.d(getTag(), "${formatter.format(Date())} $text [${Thread.currentThread().name}]")
    }

    override fun onCleared() {
        super.onCleared()
        log("super.onCleared()")
        testScope.cancel()
    }
}