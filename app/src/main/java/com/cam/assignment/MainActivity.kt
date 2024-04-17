package com.cam.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {


      private lateinit var customArrayAdapters: list_items.CustomArrayAdapters
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val list = mutableListOf<Data>()
            list.add(Data(R.drawable.toph, "Toph", 123,"BSIT"))
            list.add(Data(R.drawable.katara, "Katara", 132,"BSIT"))
            list.add(Data(R.drawable.sokka, "Sokka", 123,"BSIT"))
            list.add(Data(R.drawable.suki, "Suki", 132,"BSIT"))
            list.add(Data(R.drawable.aang, "Aang", 134,"BSIT"))

            customArrayAdapters = list_items.CustomArrayAdapters(this, list)

            val listView = findViewById<ListView>(R.id.list)

            listView.adapter = customArrayAdapters
    }
}




