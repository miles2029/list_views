package com.cam.assignment

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class studentpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentpage)

        val listView = findViewById<ListView>(R.id.listView)
        val addButton = findViewById<Button>(R.id.addButton)

        data class Student(val firstName: String, val lastName : String,val age: Int, val gradeLvl: Int) {
            override fun toString(): String {
                return "Student Name: $firstName $lastName"
            }
        }

        val studentList = mutableListOf<Student>()

        addButton.setOnClickListener {
            val firstName = findViewById<EditText>(R.id.firstName).text.toString()
            val lastName = findViewById<EditText>(R.id.lastName).text.toString()
            val age = findViewById<EditText>(R.id.age).text.toString().toInt()
            val gradeLevel = findViewById<EditText>(R.id.gradeLevel).text.toString().toInt()
            val student = Student(firstName,lastName, age, gradeLevel)

            studentList.add(student)
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, studentList)
            listView.adapter = adapter
            adapter.notifyDataSetChanged()
            Toast.makeText(this,"Student Added", Toast.LENGTH_SHORT).show()
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            val clickedStudent = studentList[position]

            val studentDetails = Dialog(this)
            studentDetails.setContentView(R.layout.activity_student_details)

            val fNameTextView = studentDetails.findViewById<TextView>(R.id.firstName)
            val lNameTextView = studentDetails.findViewById<TextView>(R.id.lastName)
            val studAge = studentDetails.findViewById<TextView>(R.id.studAge)
            val gradeLvl = studentDetails.findViewById<TextView>(R.id.gradeLvl)

            fNameTextView.text = "First Name: ${clickedStudent.firstName}"
            lNameTextView.text = "Last Name: ${clickedStudent.lastName}"
            studAge.text = "Age: ${clickedStudent.age}"
            gradeLvl.text = "Grade Level: ${clickedStudent.gradeLvl}"
            studentDetails.show()

        }


    }
}
