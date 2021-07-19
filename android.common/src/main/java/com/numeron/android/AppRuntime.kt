package com.numeron.android

import android.app.Application
import android.content.Context
import android.content.ContextWrapper

object AppRuntime {

    private lateinit var gContext: GlobalContext

    val context: Context
        get() = gContext

    fun init(application: Application) {
        gContext = GlobalContext(application)
    }

    private class GlobalContext(context: Context) : ContextWrapper(context)

}