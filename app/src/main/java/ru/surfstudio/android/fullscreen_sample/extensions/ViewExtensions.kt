package ru.surfstudio.android.fullscreen_sample.extensions

import android.view.View
import android.view.ViewGroup
import androidx.core.view.*

/**
 * Extension to update view margin.
 * You don't need to specify each value explicitly: use Kotlin named parameters.
 */
fun View.updateMargin(
        left: Int = marginLeft,
        top: Int = marginTop,
        right: Int = marginRight,
        bottom: Int = marginBottom
) = updateLayoutParams<ViewGroup.MarginLayoutParams> { updateMargins(left, top, right, bottom) }
