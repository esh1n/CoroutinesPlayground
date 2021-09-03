package com.esh1n.coroutineslab.ui.main

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AsyncAwaitSimpleVM : BaseVM() {

    override fun getTag(): String {
        return "AsyncAwaitSimpleVM"
    }
    fun onRunInParallel() {
        suspend fun getData(): String {
            delay(1000)
            return "data"
        }

        suspend fun getData2(): String {
            delay(1500)
            return "data2"
        }

        testScope.launch {
            log("parent coroutine, start")

            val data = async { getData() }
            val data2 = async { getData2() }

            log("parent coroutine, wait until children return result")
            val result = "${data.await()}, ${data2.await()}"
            log("parent coroutine, children returned: $result")

            log("parent coroutine, end")
        }
    }

}