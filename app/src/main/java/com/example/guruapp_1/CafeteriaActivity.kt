package com.example.guruapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// 식당 선택 화면(교직원 식당 or 기숙사 식당)
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