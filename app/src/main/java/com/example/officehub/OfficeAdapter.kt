package com.example.officehub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class OfficeAdapter(private val officeList: List<Office>) :
    RecyclerView.Adapter<OfficeAdapter.OfficeViewHolder>() {

    class OfficeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvOfficeName)
        val type: TextView = view.findViewById(R.id.tvOfficeType)
        val price: TextView = view.findViewById(R.id.tvOfficePrice)
        val image: ImageView = view.findViewById(R.id.ivOffice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfficeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_office, parent, false)
        return OfficeViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfficeViewHolder, position: Int) {
        val office = officeList[position]
        holder.name.text = office.name
        holder.type.text = office.type
        holder.price.text = office.price
        holder.image.setImageResource(office.imageRes)

        // Додаємо клік на всю картку
        holder.itemView.setOnClickListener {
            showDialog(holder.itemView.context, office)
        }
    }

    private fun showDialog(context: android.content.Context, office: Office) {
        val dialog = BottomSheetDialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_office_details, null)

        view.findViewById<TextView>(R.id.detailName).text = office.name
        view.findViewById<TextView>(R.id.detailType).text = office.type
        view.findViewById<TextView>(R.id.detailDesc).text = office.description
        view.findViewById<TextView>(R.id.detailPrice).text = "Ціна: ${office.price}"

        dialog.setContentView(view)
        dialog.show()
    }

    override fun getItemCount(): Int = officeList.size
}