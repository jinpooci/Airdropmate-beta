package com.example.airdropmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tv = TextView(this)
        tv.text = "AirdropMate\nTap the button to visit documentation"
        tv.textSize = 18f
        tv.gravity = Gravity.CENTER

        val btn = Button(this)
        btn.text = "Open Docs"
        btn.setOnClickListener {
            val url = "https://github.com/jinpooci/Airdropmate-beta"
            try {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            } catch (e: Exception) {
                Toast.makeText(this, "Cannot open URL", Toast.LENGTH_SHORT).show()
            }
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            val p = 40
            setPadding(p, p, p, p)
            addView(tv)
            addView(btn)
        }

        setContentView(layout)
    }
}
