package ru.surfstudio.android.fullscreen_sample.kitkat

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.FrameLayout
import ru.surfstudio.android.fullscreen_sample.utils.InsetUtil
import ru.surfstudio.android.fullscreen_sample.utils.OnSystemInsetsChangedListener

/**
 * [FrameLayout] with translucent StatusBar and NavigationBar on Kitkat.
 */
class KitkatTransparentSystemBarsFrame @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = -1
) : FrameLayout(context, attrs, defStyleAttr), KitkatTransparentSystemBarsContainer {

    override var onSystemInsetsChangedListener: OnSystemInsetsChangedListener = { _, _ -> }

    override fun fitSystemWindows(insets: Rect?): Boolean {
        insets ?: return false
        val desiredBottomInset = InsetUtil.calculateDesiredBottomInset(
                this,
                insets.top,
                insets.bottom,
                onSystemInsetsChangedListener
        )
        return super.fitSystemWindows(Rect(0, 0, 0, desiredBottomInset))
    }
}