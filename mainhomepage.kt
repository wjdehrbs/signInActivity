package com.example.signlnactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class mainhomepage : AppCompatActivity() {
    private val signUpActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            if (data != null) {
                val userIdFromSignUp = data.getStringExtra("dataFromSignUpActivity")
                val passwordFromSignUp = data.getStringExtra("passwordFromSignUpActivity")
                val textId = findViewById<EditText>(R.id.editTextId)
                val textPass = findViewById<EditText>(R.id.editText_password)
                textId.setText(userIdFromSignUp)
                textPass.setText(passwordFromSignUp)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        val btn_add2 = findViewById<Button>(R.id.login)
        btn_add2.setOnClickListener {
            val edit_Text = findViewById<EditText>(R.id.editTextId)
            val strData = edit_Text.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("dataFromMainActivity", strData)
            val textId = findViewById<EditText>(R.id.editTextId)
            val textPass = findViewById<EditText>(R.id.editText_password)
            val userId = textId.text.toString()
            val password = textPass.text.toString()

            if (userId.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else if (userId == "sparta" && password == "password") {
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "아이디나 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
            }

        }

            val btn_add = findViewById<Button>(R.id.singup_btn)
        btn_add.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }
}
