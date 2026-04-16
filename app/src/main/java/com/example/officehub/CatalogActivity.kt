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

        val officeList = listOf(
            Office(1, "Sky Tower Premium", "Бізнес", "850 000 $", "Елітний офіс 450 м² у центрі (вул. Велика Васильківська, 5). Панорама 360°, VIP-зал для переговорів, підземна парковка на 10 авто та цілодобова охорона.", R.drawable.off_sky_premium),
            Office(2, "Auto Plaza Showroom", "Для машин", "1 200 000 $", "Величезний шоурум 800 м² (Західне шосе, 12). Фасадне скління, зона сервісу, великий склад запчастин та майданчик для виставки 50 автомобілів під відкритим небом.", R.drawable.off_auto_plaza),
            Office(3, "Central Reserve Bank", "Банк", "2 500 000 $", "Історична будівля банку (пл. Свободи, 1). Сховища 5-го класу безпеки, автономне живлення, броньовані вікна та спеціалізована серверна кімната з кіберзахистом.", R.drawable.off_central_bank),
            Office(4, "Cyber Drive Hub", "Для машин", "980 000 $", "Інноваційний хаб в IT-Парку (вул. Технологічна, 44). Зарядні станції Supercharger, скляний дах, інтерактивні панелі для конфігурації авто та система Smart Lighting.", R.drawable.off_cyber_drive),
            Office(5, "Green Leaf Studio", "Бізнес", "550 000 $", "Еко-офіс майбутнього (вул. Садова, 10). Вертикальні сади на фасаді, сонячні панелі, сертифікація LEED та власна тераса на даху для відпочинку з видом на парк.", R.drawable.off_green_leaf)
        )

        rvCatalog.layoutManager = LinearLayoutManager(this)
        rvCatalog.adapter = OfficeAdapter(officeList)
    }
}