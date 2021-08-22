package cn.numeron.android

import android.content.Context
import android.content.ContextWrapper

internal class GlobalContext(context: Context) : ContextWrapper(context)