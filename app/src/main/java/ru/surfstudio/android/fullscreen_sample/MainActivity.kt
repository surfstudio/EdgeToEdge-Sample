package ru.surfstudio.android.fullscreen_sample

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import ru.surfstudio.android.fullscreen_sample.extensions.setWindowTransparency
import ru.surfstudio.android.fullscreen_sample.extensions.setWindowTransparencyKitkat
import ru.surfstudio.android.fullscreen_sample.extensions.updateMargin
import ru.surfstudio.android.fullscreen_sample.kitkat.KitkatTransparentSystemBarsFrame
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar as Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ->
                setWindowTransparency(::updateMargins)
            Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT -> {
                val kitkatContainer = findViewById<KitkatTransparentSystemBarsFrame>(R.id.kitkat_container)
                setWindowTransparencyKitkat(kitkatContainer, ::updateMargins)
            }
            else -> { /*do nothing*/ }
        }

        change_bg_btn.setOnClickListener { bg_container.setBackgroundColor(getRandomColor()) }
    }

    private fun updateMargins(statusBarSize: Int, navigationBarSize: Int) {
        toolbar.updateMargin(top = statusBarSize)
        change_bg_btn.updateMargin(bottom = navigationBarSize)
    }

    private fun getRandomColor(): Int {
        val colors = arrayOf(Color.YELLOW, Color.BLUE, Color.DKGRAY, Color.GREEN, Color.MAGENTA, Color.RED, Color.GREEN)
        return colors[Random.nextInt(colors.size)]
    }
}
