package com.example.officehub

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nameField = findViewById<EditText>(R.id.regName)
        val emailField = findViewById<EditText>(R.id.regEmail)
        val passField = findViewById<EditText>(R.id.regPass)
        val confirmPassField = findViewById<EditText>(R.id.regPassConfirm)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = nameField.text.toString()
            val email = emailField.text.toString()
            val password = passField.text.toString()
            val confirmPass = confirmPassField.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Заповніть всі поля!", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPass) {
                Toast.makeText(this, "Паролі не збігаються!", Toast.LENGTH_SHORT).show()
            } else {
                // --- ЗБЕРЕЖЕННЯ ДАНИХ У ПАМ'ЯТЬ ---
                val prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val editor = prefs.edit()
                editor.putString("USER_NAME", name)
                editor.putString("USER_EMAIL", email)
                editor.apply()
                // ----------------------------------

                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("SAVED_EMAIL", email)
                intent.putExtra("SAVED_PASS", password)

                Toast.makeText(this, "Реєстрація успішна!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
        }
    }
}