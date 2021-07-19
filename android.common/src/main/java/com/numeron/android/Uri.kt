package com.numeron.android

import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import java.io.File

fun File.toUri(): Uri {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        FileProvider.getUriForFile(AppRuntime.context, "${AppRuntime.context.packageName}.fileProvider", this)
    } else {
        Uri.fromFile(this)
    }
}