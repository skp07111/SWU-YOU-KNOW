package com.example.guruapp_1

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_auditorium.*
import kotlinx.android.synthetic.main.activity_cafeteria.*
import kotlinx.android.synthetic.main.activity_shalom.*
import java.util.*

class CafeteriaActivity : AppCompatActivity() {

    lateinit var staffMain: Button
    lateinit var dormitoryMain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafeteria)

        staffMain = findViewById<Button>(R.id.staff_cafeteria_btn)
        dormitoryMain = findViewById<Button>(R.id.shalom_button1)

        staffMain.setOnClickListener() {
            var intent = Intent(this, StaffCafeteria::class.java)
            startActivity(intent)
        }

        dormitoryMain.setOnClickListener() {
            var intent = Intent(this, DormitoryCafeteria::class.java)
            startActivity(intent)
        }
        disabledDorm()
    }

    private fun disabledDorm() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                shalom_button1.setBackgroundResource(R.drawable.button_background4)
                shalom_button1.setOnClickListener() {
                    false
                }
                unregisterForContextMenu(shalom_button1)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 11)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                shalom_button1.setOnClickListener() {
                    true
                }
                registerForContextMenu(shalom_button1)
            }
        }, cal.time)
    }
}