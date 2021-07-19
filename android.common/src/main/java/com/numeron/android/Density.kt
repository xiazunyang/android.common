@file:JvmName("Density")

package com.numeron.android


/* dp/px 相关工具 */
private val density by lazy {
    AppRuntime.context.resources.displayMetrics.density
}

/* from dp to px */
val Int.dp: Int
    get() = (density * this + 0.5f).toInt()

val Float.dp: Float
    get() = density * this + 0.5f

/* from px to dp */
fun fromDp(dp: Int): Int = (dp / density + 0.5f).toInt()

fun fromDp(dp: Float): Float = dp / density + 0.5f


/* sp/px 相关工具 */
private val scaledDensity by lazy {
    AppRuntime.context.resources.displayMetrics.scaledDensity
}

/* from sp to px */
val Int.sp: Int
    get() = (scaledDensity * this + 0.5f).toInt()

val Float.sp: Float
    get() = scaledDensity * this + 0.5f

/* from px to sp */
fun fromSp(sp: Int): Float = sp / scaledDensity + 0.5f

fun fromSp(sp: Float): Float = sp / scaledDensity + 0.5f