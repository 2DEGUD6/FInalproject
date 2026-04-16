package com.example.officehub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatalogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val rvCatalog = findViewById<RecyclerView>(R.id.rvCatalog)

        // Твій список преміальних офісів
        val officeList = listOf(
            Office(1, "Sky Tower Premium", "Бізнес", "850 000 $", "Елітний офіс 450 м² у центрі. Панорама 360°, VIP-зал для переговорів.", R.drawable.off_sky_premium),
            Office(2, "Auto Plaza Showroom", "Для машин", "1 200 000 $", "Величезний шоурум 800 м². Зона сервісу та склад запчастин.", R.drawable.off_auto_plaza),
            Office(3, "Central Reserve Bank", "Банк", "2 500 000 $", "Історична будівля банку. Сховища 5-го класу безпеки.", R.drawable.off_central_bank),
            Office(4, "Cyber Drive Hub", "Для машин", "980 000 $", "Інноваційний хаб в IT-Парку. Зарядні станції Supercharger.", R.drawable.off_cyber_drive),
            Office(5, "Green Leaf Studio", "Бізнес", "550 000 $", "Еко-офіс майбутнього з вертикальними садами та сонячними панелями.", R.drawable.off_green_leaf)
        )

        rvCatalog.layoutManager = LinearLayoutManager(this)

        // Встановлюємо адаптер
        rvCatalog.adapter = OfficeAdapter(officeList)
    }
}