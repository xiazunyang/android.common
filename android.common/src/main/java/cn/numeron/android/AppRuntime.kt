package cn.numeron.android

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

object AppRuntime {

    private lateinit var gHandle: Handler

    private lateinit var gContext: GlobalContext

    private lateinit var gMainExecutor: MainExecutor

    /** 获取AndroidManifest.xml中的配置 */
    val metaData = Bundle()

    /** 返回[Context]实例 */
    val context: Context
        get() = gContext

    /** 返回[Handler]实例。 */
    val handle: Handler
        get() {
            if (!::gHandle.isInitialized) {
                gHandle = Handler(Looper.getMainLooper())
            }
            return gHandle
        }

    /** 返回运行在主线程上的[Executor]实例 */
    val mainExecutor: MainExecutor
        get() {
            if (!::gMainExecutor.isInitialized) {
                gMainExecutor = MainExecutor(handle)
            }
            return gMainExecutor
        }

    fun init(context: Context) {
        context.packageManager
            .getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            .metaData?.let(metaData::putAll)
        if (!AppRuntime::gContext.isInitialized) {
            gContext = GlobalContext(context)
        }
        if (!AppRuntime::gHandle.isInitialized) {
            gHandle = Handler(context.mainLooper)
        }
        if (!AppRuntime::gMainExecutor.isInitialized) {
            gMainExecutor = MainExecutor(gHandle)
        }
    }

}