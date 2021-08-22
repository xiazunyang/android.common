package cn.numeron.android

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class MainExecutor(private val mainHandle: Handler) : Executor {

    val isMainThread: Boolean
        get() = Looper.myLooper() == mainHandle.looper

    override fun execute(command: Runnable) {
        mainHandle.post(command)
    }

    fun assertMainThread(methodName: String) {
        check(isMainThread) {
            "Cannot invoke $methodName on a background thread."
        }
    }

}