package cn.numeron.android

import androidx.core.content.FileProvider

open class NumeronFileProvider : FileProvider() {

    override fun onCreate(): Boolean {
        AppRuntime.init(requireContext())
        return super.onCreate()
    }

}