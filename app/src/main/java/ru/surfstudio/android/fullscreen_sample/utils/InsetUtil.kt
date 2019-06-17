package ru.surfstudio.android.fullscreen_sample.utils

import android.view.View
import androidx.core.view.ViewCompat

typealias OnSystemInsetsChangedListener = (statusBarSize: Int, navigationBarSize: Int) -> Unit

/**
 * Util class for window insets
 */
object InsetUtil {

    /**
     * Removes system insets to make view hierarchy appear from edge to edge.
     *
     * @param view          view to remove insets
     * @param listener      listener that listens for updates top and bottom system insets of a view
     */
    fun removeSystemInsets(view: View, listener: OnSystemInsetsChangedListener) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->

            val desiredBottomInset = calculateDesiredBottomInset(
                    view,
                    insets.systemWindowInsetTop,
                    insets.systemWindowInsetBottom,
                    listener
            )

            ViewCompat.onApplyWindowInsets(
                    view,
                    insets.replaceSystemWindowInsets(0, 0, 0, desiredBottomInset)
            )
        }
    }

    /**
     * Calculates desired bottom inset in pixels to make NavigationBar transparent,
     * or to show the keyboard on the screen.
     *
     * @param view          view to calculate insets
     * @param topInset      system top inset in pixels
     * @param bottomInset   system bottom inset in pixels
     * @param listener      listener that listens for updates top and bottom system insets of a view
     */
    fun calculateDesiredBottomInset(
            view: View,
            topInset: Int,
            bottomInset: Int,
            listener: OnSystemInsetsChangedListener
    ): Int {
        val hasKeyboard = isKeyboardAppeared(view, bottomInset)
        val desiredBottomInset = if (hasKeyboard) bottomInset else 0
        listener(topInset, if (hasKeyboard) 0 else bottomInset)
        return desiredBottomInset
    }

    private fun isKeyboardAppeared(view: View, bottomInset: Int) =
            bottomInset / view.resources.displayMetrics.heightPixels.toDouble() > .25

}