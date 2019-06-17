package ru.surfstudio.android.fullscreen_sample.extensions

import android.annotation.TargetApi
import android.app.Activity
import android.graphics.Color
import android.view.WindowManager
import ru.surfstudio.android.fullscreen_sample.kitkat.KitkatTransparentSystemBarsContainer
import ru.surfstudio.android.fullscreen_sample.utils.InsetUtil
import ru.surfstudio.android.fullscreen_sample.utils.OnSystemInsetsChangedListener

/**
 * Sets StatusBar and NavigationBar transparency for devices with Lollipop and higher.
 * Works best when the root layout has flag android:fitsSystemWindows="true"
 *
 * @param listener      listener that listens for updates top and bottom system insets of a view
 */
@TargetApi(21)
fun Activity.setWindowTransparency(listener: OnSystemInsetsChangedListener = { _, _ -> }) {
    InsetUtil.removeSystemInsets(window.decorView, listener)
    window.navigationBarColor = Color.TRANSPARENT
    window.statusBarColor = Color.TRANSPARENT
}

/**
 * Sets StatusBar and NavigationBar transparency for Kitkat devices.
 * Works best when the root layout has flag android:fitsSystemWindows="true"
 *
 * @param rootView      root view to dispatch updated insets
 * @param listener      listener that listens for updates top and bottom system insets of a view
 */
@TargetApi(19)
fun Activity.setWindowTransparencyKitkat(
        rootView: KitkatTransparentSystemBarsContainer,
        listener: OnSystemInsetsChangedListener = { _, _ -> }
) {
    window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    rootView.onSystemInsetsChangedListener = listener
}