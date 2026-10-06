package com.nexacore.ai
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this).apply {
            text = "BOO V2 ONLINE"
            textSize = 24f
            gravity = android.view.Gravity.CENTER
        }
        setContentView(tv)
    }
}
