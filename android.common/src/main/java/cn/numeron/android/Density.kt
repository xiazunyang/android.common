@file:JvmName("Density")

package cn.numeron.android


/* dp/px 相关工具 */
private val density by lazy {
    AppRuntime.context.resources.displayMetrics.density
}

val Int.dp: Int
    get() = (density * this + 0.5f).toInt()

val Float.dp: Float
    get() = density * this + 0.5f

/* sp/px 相关工具 */
private val scaledDensity by lazy {
    AppRuntime.context.resources.displayMetrics.scaledDensity
}

val Int.sp: Int
    get() = (scaledDensity * this + 0.5f).toInt()

val Float.sp: Float
    get() = scaledDensity * this + 0.5f