@file:JvmName("Density")

package cn.numeron.android


/* dp/px 相关工具 */
private val density: Float
    get() = AppRuntime.context.resources.displayMetrics.density

val Int.dp: Int
    get() = (density * this).toInt()

val Float.dp: Float
    get() = density * this

/* sp/px 相关工具 */
private val scaledDensity: Float
    get() = AppRuntime.context.resources.displayMetrics.scaledDensity

val Int.sp: Int
    get() = (scaledDensity * this).toInt()

val Float.sp: Float
    get() = scaledDensity * this
