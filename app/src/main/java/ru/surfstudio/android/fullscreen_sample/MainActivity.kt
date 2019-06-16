package ru.surfstudio.android.fullscreen_sample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import ru.surfstudio.android.fullscreen_sample.extensions.setWindowTransparency
import ru.surfstudio.android.fullscreen_sample.extensions.updateMargin
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar as Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setWindowTransparency { statusBarSize, navigationBarSize ->
            toolbar.updateMargin(top = statusBarSize)
            btn.updateMargin(bottom = navigationBarSize)
        }
        btn.setOnClickListener { container.setBackgroundColor(getRandomColor()) }
    }

    private fun getRandomColor(): Int {
        val colors = arrayOf(Color.YELLOW, Color.BLUE, Color.DKGRAY, Color.GREEN, Color.MAGENTA, Color.RED, Color.GREEN)
        return colors[Random.nextInt(colors.size)]
    }
}
