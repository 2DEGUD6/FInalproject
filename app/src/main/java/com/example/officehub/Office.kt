package com.example.officehub

data class Office(
    val id: Int,
    val name: String,
    val type: String, // "Для авто", "Банк", "Бізнес"
    val price: String,
    val description: String,
    val imageRes: Int // Посилання на картинку в drawable
)