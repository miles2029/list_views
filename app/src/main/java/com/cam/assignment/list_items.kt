package com.cam.assignment

import android.app.Activity
import android.content.Intent
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class list_items : AppCompatActivity() {
    class CustomArrayAdapters(val activity: Activity, val list: List<Data>) :
        ArrayAdapter<Data>(activity, R.layout.activity_list_items) {

        override fun getCount(): Int {
            return list.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val contexts = activity.layoutInflater
            val rowView = contexts.inflate(R.layout.activity_list_items, null)

            val images = rowView.findViewById<ImageView>(R.id.images)
            val name = rowView.findViewById<TextView>(R.id.name)
            val idNumber = rowView.findViewById<TextView>(R.id.idNumber)
            val program = rowView.findViewById<TextView>(R.id.program)

            val currentItem = list[position]

            program.text = currentItem.program
            name.text = currentItem.name
            idNumber.text = currentItem.idNumber.toString()
            images.setImageResource(currentItem.image)

            rowView.setOnClickListener {
                val intent = Intent(activity, ContactsContract.Profile::class.java)
                intent.putExtra("program",currentItem.program)
                intent.putExtra("idNumber", currentItem.idNumber)
                intent.putExtra("name", currentItem.name)
                intent.putExtra("image", currentItem.image)
                activity.startActivity(intent)
            }

            return rowView
        }
    }
}
