package ru.surfstudio.android.fullscreen_sample.extensions

import android.view.View
import android.view.ViewGroup
import androidx.core.view.*


/**
 * Установка нулевого отступа сверху для [View]
 * Вызывается для того, чтобы [View] умещался под статус-бар
 */
fun View.setZeroTopInset() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, insets ->
        ViewCompat.onApplyWindowInsets(
            this,
            insets.replaceSystemWindowInsets(
                insets.systemWindowInsetLeft,
                0,
                insets.systemWindowInsetRight,
                insets.systemWindowInsetBottom
            )
        )
    }
}

/**
 * Подстановка верхнего отступа для [View] на основе высоты статус бара
 */
fun View.setStatusBarTopMargin() {
    updateLayoutParams<ViewGroup.MarginLayoutParams> { updateMargins(top = marginTop + context.getStatusBarHeight()) }
}

/**
 * Подстановка верхнего отступа для [View] на основе высоты статус бара
 */
fun View.setStatusBarTopPadding() {
    updatePadding(top = paddingTop + context.getStatusBarHeight())
}

fun View.setNavbarBottomMargin() {
    updateLayoutParams<ViewGroup.MarginLayoutParams> { updateMargins(bottom = marginBottom + context.getNavBarHeight()) }
}

fun View.setNavBarBottomPadding() {
    updatePadding(bottom = paddingBottom + context.getNavBarHeight())
}