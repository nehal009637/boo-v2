package com.nexacore.ai

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = android.view.Gravity.CENTER
            setPadding(50, 50, 50, 50)
        }

        val tv = TextView(this).apply {
            text = "BOO V2 - Control Panel"
            textSize = 24f
            gravity = android.view.Gravity.CENTER
        }

        val btn = Button(this).apply {
            text = "Launch Floating Orb"
            setOnClickListener {
                checkOverlayPermissionAndStart()
            }
        }

        layout.addView(tv)
        layout.addView(btn)
        setContentView(layout)
    }

    private fun checkOverlayPermissionAndStart() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:$packageName")
            )
            startActivity(intent)
        } else {
            startService(Intent(this, FloatingOrbService::class.java))
        }
    }
}
