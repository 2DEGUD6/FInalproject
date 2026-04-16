package com.example.officehub

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvLogin = findViewById<TextView>(R.id.profileLogin)
        val etName = findViewById<EditText>(R.id.profileName)
        val etEmail = findViewById<EditText>(R.id.profileEmail)
        val btnSave = findViewById<Button>(R.id.btnSaveProfile)

        // Читаємо дані з пам'яті "UserPrefs"
        val prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        // Якщо даних немає, поставимо порожній рядок ""
        val savedName = prefs.getString("USER_NAME", "")
        val savedEmail = prefs.getString("USER_EMAIL", "")

        // Встановлюємо текст (якщо він порожній, користувач побачить android:hint з XML)
        tvLogin.text = savedName // Зазвичай логін — це те саме ім'я або окреме поле
        etName.setText(savedName)
        etEmail.setText(savedEmail)

        btnSave.setOnClickListener {
            // Зберігаємо оновлені користувачем дані
            val editor = prefs.edit()
            editor.putString("USER_NAME", etName.text.toString())
            editor.putString("USER_EMAIL", etEmail.text.toString())
            editor.apply()

            Toast.makeText(this, "Дані оновлено!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}