package com.numeron.android

import android.content.Context
import android.os.Handler
import android.os.Looper

object AppRuntime {

    private lateinit var gHandle: Handler

    private lateinit var gContext: GlobalContext

    private lateinit var gMainExecutor: MainExecutor

    val context: Context
        get() = gContext

    val handle: Handler
        get() {
            if (!::gHandle.isInitialized) {
                gHandle = Handler(Looper.getMainLooper())
            }
            return gHandle
        }

    val mainExecutor: MainExecutor
        get() {
            if (!::gMainExecutor.isInitialized) {
                gMainExecutor = MainExecutor(handle)
            }
            return gMainExecutor
        }

    fun init(context: Context) {
        if (!::gContext.isInitialized) {
            gContext = GlobalContext(context)
        }
        if (!::gHandle.isInitialized) {
            gHandle = Handler(context.mainLooper)
        }
        if (!::gMainExecutor.isInitialized) {
            gMainExecutor = MainExecutor(gHandle)
        }
    }

}