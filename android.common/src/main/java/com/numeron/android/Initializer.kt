package com.numeron.android

import android.content.Context
import androidx.startup.Initializer

class Initializer : Initializer<Unit> {

    override fun create(context: Context) {
        AppRuntime.init(context)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()

}