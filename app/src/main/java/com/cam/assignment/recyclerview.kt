// recyclerview.kt
package com.cam.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class recyclerview : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NameListAdapter
    private val nameList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        editText = findViewById(R.id.editText)
        recyclerView = findViewById(R.id.recyclerView)
        adapter = NameListAdapter(nameList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.button).setOnClickListener {
            val name = editText.text.toString()
            if (name.isNotEmpty()) {
                nameList.add(name)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }
    }

    private class NameListAdapter(private val dataList: List<String>) :
        RecyclerView.Adapter<NameListAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(dataList[position])
        }

        override fun getItemCount(): Int = dataList.size

        private class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: String) {
                itemView.findViewById<TextView>(android.R.id.text1).text = item
            }
        }
    }
}
