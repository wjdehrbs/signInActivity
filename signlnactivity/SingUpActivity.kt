package com.example.signlnactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SingUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        val btn_add = findViewById<Button>(R.id.btn_singup)
        btn_add.setOnClickListener {
            val textname = findViewById<EditText>(R.id.edit_name)
            val textId = findViewById<EditText>(R.id.edittextId)
            val textPass = findViewById<EditText>(R.id.editTextPw)

            val username = textname.text.toString()
            val userId = textId.text.toString()
            val password = textPass.text.toString()

            if (username.isEmpty() || userId.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "회원가입 성공!!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}


