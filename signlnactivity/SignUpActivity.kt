package com.example.signlnactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn_add = findViewById<Button>(R.id.btn_signup)
        btn_add.setOnClickListener {
            val textname = findViewById<EditText>(R.id.edit_name)
            val text_Id = findViewById<EditText>(R.id.edittextId)
            val text_Pass = findViewById<EditText>(R.id.editTextPw)
            val username = textname.text.toString()
            val userId = text_Id.text.toString()
            val password = text_Pass.text.toString()


            if (username.isEmpty() || userId.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "회원가입 성공!!", Toast.LENGTH_SHORT).show()

                val resultIntent = Intent()
                resultIntent.putExtra("dataFromSignUpActivity", userId)
                resultIntent.putExtra("passwordFromSignUpActivity", password)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}


