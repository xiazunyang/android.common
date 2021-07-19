package com.numeron.android

import androidx.core.content.FileProvider

open class InitialFileProvider : FileProvider() {

    override fun onCreate(): Boolean {
        AppRuntime.init(requireContext())
        return super.onCreate()
    }

}