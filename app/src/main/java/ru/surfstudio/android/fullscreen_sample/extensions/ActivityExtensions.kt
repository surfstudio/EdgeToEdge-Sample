package ru.surfstudio.android.fullscreen_sample.extensions

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager

typealias OnSystemBarsSizeChangedListener = (statusBarSize: Int, navigationBarSize: Int) -> Unit

/**
 * Установка прозрачности для Navigation Bar и Status Bar
 * при установленом у корневого layout'а параметре android:fitsSystemWindows="true"
 */
fun Activity.setWindowTransparency(listener: OnSystemBarsSizeChangedListener = { _, _ -> }) {
    window.decorView.removeSystemInsets(listener)
    setStatusBarTransparency()
}

/**
 * Установка прозрачного статус-бара
 * TODO пересмотреть, возможно получится полностью уйти от этого метода к window insets
 */
@SuppressLint("NewApi")
fun Activity.setStatusBarTransparency() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT
    } else {
        val translucentFlag = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        window.addFlags(translucentFlag)
    }

}

/**
 * Установка прозрачного navigation-бара
 * TODO пересмотреть, возможно получится полностью уйти от этого метода к window insets
 */
@SuppressLint("NewApi")
fun Activity.setNavigationBarTransparency() {
    window.addFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION or
                    WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
    )
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.navigationBarColor = Color.TRANSPARENT
    }
}