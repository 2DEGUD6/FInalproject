package com.example.officehub

import android.content.Context
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

        // Дістаємо збережені дані з пам'яті телефону
        val prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val savedEmail = prefs.getString("USER_EMAIL", null)
        val savedPass = prefs.getString("USER_PASS", null) // Переконайся, що в RegisterActivity ти також зберігаєш USER_PASS
        val savedName = prefs.getString("USER_NAME", "Користувач")

        val emailField = findViewById<EditText>(R.id.loginEmail)
        val passField = findViewById<EditText>(R.id.loginPass)
        val btnEnter = findViewById<Button>(R.id.btnLoginEnter)

        btnEnter.setOnClickListener {
            val inputEmail = emailField.text.toString()
            val inputPass = passField.text.toString()

            // Перевірка: чи збігається введений текст із тим, що в пам'яті
            // Якщо savedEmail == null, значить реєстрації ще не було
            if (inputEmail == savedEmail && inputPass == savedPass) {
                Toast.makeText(this, "Ласкаво просимо, $savedName!", Toast.LENGTH_SHORT).show()

                // Переходимо на головний екран
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Неправильна пошта або пароль!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}