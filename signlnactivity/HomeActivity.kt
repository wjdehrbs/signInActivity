package com.example.signlnactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val strData = intent.getStringExtra("dataFromMainActivity")
        val textView = findViewById<TextView>(R.id.textView)
        textView.setText(strData)

        val btn = findViewById<Button>(R.id.btn_close)
        btn.setOnClickListener {
            finish()
        }
    }
}