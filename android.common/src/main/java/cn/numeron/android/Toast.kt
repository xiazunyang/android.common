package cn.numeron.android

import android.content.Context
import android.widget.Toast

inline fun <reified T : Context> T.toast(text: String): Toast {
    return Toast.makeText(this, text, Toast.LENGTH_SHORT).apply(Toast::show)
}

inline fun <reified T : Context> T.longToast(text: String): Toast {
    return Toast.makeText(this, text, Toast.LENGTH_LONG).apply(Toast::show)
}