package ru.surfstudio.android.fullscreen_sample.kitkat

import ru.surfstudio.android.fullscreen_sample.utils.OnSystemInsetsChangedListener

/**
 * Interface for Views that has transparent StatusBar and NavigationBar in Android Kitkat.
 *
 * @property onSystemInsetsChangedListener listener that listens for updates top and bottom system insets of a view

 */
interface KitkatTransparentSystemBarsContainer {
    var onSystemInsetsChangedListener: OnSystemInsetsChangedListener
}