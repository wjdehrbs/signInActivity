package com.example.signlnactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val ir = findViewById<ImageView>(R.id.imagerd)

        val id = when ((1..5).random()){
            1 -> R.drawable.rd1
            2 -> R.drawable.rd2
            3 -> R.drawable.rd3
            4 -> R.drawable.rd4
            else-> R.drawable.rd5
        }

        ir.setImageDrawable(ResourcesCompat.getDrawable(resources, id, null))

        val strData = intent.getStringExtra("dataFromMainActivity")
        val textView = findViewById<TextView>(R.id.textView)
        textView.setText(strData)

        val btn = findViewById<Button>(R.id.btn_close)
        btn.setOnClickListener {
            finish()
        }
    }
}