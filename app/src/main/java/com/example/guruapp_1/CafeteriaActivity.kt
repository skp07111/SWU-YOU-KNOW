package com.example.guruapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CafeteriaActivity : AppCompatActivity() {

    lateinit var staffMain: Button
    lateinit var dormitoryMain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafeteria)

        staffMain = findViewById<Button>(R.id.staff_cafeteria_btn)
        dormitoryMain = findViewById<Button>(R.id.dormitory_cafeteria_btn)

        staffMain.setOnClickListener() {
            var intent = Intent(this, StaffCafeteria::class.java)
            startActivity(intent)
        }

        dormitoryMain.setOnClickListener() {
            var intent = Intent(this, DormitoryCafeteria::class.java)
            startActivity(intent)
        }
    }
}