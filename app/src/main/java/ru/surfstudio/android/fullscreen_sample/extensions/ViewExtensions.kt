package ru.surfstudio.android.fullscreen_sample.extensions

import android.view.View
import android.view.ViewGroup
import androidx.core.view.*

const val POSSIBLE_KEYBOARD_HEIGHT = 400

/**
 * Установка нулевого отступа сверху для [View]
 * Вызывается для того, чтобы [View] умещался под статус-бар
 */
fun View.removeSystemInsets(listener: OnSystemBarsSizeChangedListener) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, insets ->

        val systemTopInset = insets.systemWindowInsetTop
        val systemBottomInset = insets.systemWindowInsetBottom

        val desiredBottomInset = if (systemBottomInset > POSSIBLE_KEYBOARD_HEIGHT) {
            systemBottomInset
        } else {
            0
        }

        listener.invoke(systemTopInset, if (desiredBottomInset == 0) systemBottomInset else 0)

        ViewCompat.onApplyWindowInsets(
                this,
                insets.replaceSystemWindowInsets(0, 0, 0, desiredBottomInset)
        )
    }
}

fun View.updateMargin(
        start: Int = marginStart,
        top: Int = marginTop,
        end: Int = marginEnd,
        bottom: Int = marginBottom
) = updateLayoutParams<ViewGroup.MarginLayoutParams> { updateMarginsRelative(start, top, end, bottom) }