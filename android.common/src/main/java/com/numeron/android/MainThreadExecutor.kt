package com.numeron.android

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

object MainThreadExecutor : Executor {

    val handle by lazy {
        Handler(Looper.getMainLooper())
    }

    val isMainThread: Boolean
        get() = Looper.myLooper() == handle.looper

    override fun execute(command: Runnable) {
        handle.post(command)
    }

    fun assertMainThread(methodName: String) {
        check(isMainThread) {
            "Cannot invoke $methodName on a background thread."
        }
    }

}