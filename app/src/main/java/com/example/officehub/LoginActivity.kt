package com.example.officehub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Отримуємо дані, які прилетіли з RegisterActivity
        val savedEmail = intent.getStringExtra("SAVED_EMAIL")
        val savedPass = intent.getStringExtra("SAVED_PASS")
        val savedName = intent.getStringExtra("SAVED_NAME")

        val emailField = findViewById<EditText>(R.id.loginEmail)
        val passField = findViewById<EditText>(R.id.loginPass)
        val btnEnter = findViewById<Button>(R.id.btnLoginEnter)

        btnEnter.setOnClickListener {
            val inputEmail = emailField.text.toString()
            val inputPass = passField.text.toString()

            // Перевірка: чи збігається введений текст із тим, що прийшло з реєстрації
            if (inputEmail == savedEmail && inputPass == savedPass) {
                Toast.makeText(this, "Ласкаво просимо, $savedName!", Toast.LENGTH_SHORT).show()

                // Переходимо на головний екран (MainActivity)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_NAME", savedName) // передаємо ім'я для профілю
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Неправильна пошта або пароль!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}