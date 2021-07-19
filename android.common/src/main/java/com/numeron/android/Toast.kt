package com.numeron.android

import android.content.Context
import android.widget.Toast

private val globalToast by lazy {
    Toast.makeText(AppRuntime.context, null, Toast.LENGTH_SHORT)
}

/**
 * 及时的、尽快的显示一个Toast，多次调用此方法的Toast会被后调用的覆盖
 * @param text String 要显示的文本
 * @return Toast 单例的Toast对象
 */
fun timelyToast(text: String): Toast {
    globalToast.duration = Toast.LENGTH_SHORT
    globalToast.setText(text)
    globalToast.show()
    return globalToast
}

/**
 * 同上，但是显示的时间稍长一点
 */
fun timelyLongToast(text: String): Toast {
    globalToast.duration = Toast.LENGTH_LONG
    globalToast.setText(text)
    globalToast.show()
    return globalToast
}

inline fun <reified T : Context> T.toast(text: String): Toast {
    return Toast.makeText(this, text, Toast.LENGTH_SHORT).apply(Toast::show)
}

inline fun <reified T : Context> T.longToast(text: String): Toast {
    return Toast.makeText(this, text, Toast.LENGTH_LONG).apply(Toast::show)
}