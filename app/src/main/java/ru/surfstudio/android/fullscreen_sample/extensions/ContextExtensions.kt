package ru.surfstudio.android.fullscreen_sample.extensions

import android.app.Activity
import android.content.Context

/**
 * Получение высоты статус-бара
 */
fun Context.getStatusBarHeight(): Int {
    val statusBarHeightId = resources.getIdentifier(
        "status_bar_height",
        "dimen",
        "android"
    )
    return if (statusBarHeightId > 0) {
        resources.getDimensionPixelSize(statusBarHeightId)
    } else {
        0
    }
}

fun Context.getNavBarHeight(): Int {
    val hasNavBarId = resources.getIdentifier("config_showNavigationBar", "bool", "android")
    val hasNavBar = hasNavBarId > 0 && resources.getBoolean(hasNavBarId)

    if (!hasNavBar) return 0
    val navBarHeightId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (navBarHeightId > 0) {
        resources.getDimensionPixelSize(navBarHeightId)
    } else {
        0
    }
}