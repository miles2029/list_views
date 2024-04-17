package com.cam.assignment

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profileImage = findViewById<ImageView>(R.id.images)
        val profileName = findViewById<TextView>(R.id.name)
        val profileIdNumber = findViewById<TextView>(R.id.idNumber)
        val profileProgram = findViewById<TextView>(R.id.program)

        val program = intent.getStringExtra("program")
        val idNumber = intent.getIntExtra("idNumber", 0)
        val name = intent.getStringExtra("name")
        val image = intent.getIntExtra("image", R.drawable.ic_launcher_background)

        profileImage.setImageResource(image)
        profileName.text = name
        profileIdNumber.text = idNumber.toString()
        profileProgram.text = program
    }
}
