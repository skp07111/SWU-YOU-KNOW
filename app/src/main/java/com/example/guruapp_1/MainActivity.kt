package com.example.guruapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var storeMain: ImageButton
    lateinit var ShuttleBusMain : ImageButton
    lateinit var spaceMain: ImageButton
    lateinit var cafeteriaMain : ImageButton
    lateinit var titleLogo : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storeMain = findViewById<ImageButton>(R.id.swu_store)
        ShuttleBusMain = findViewById<ImageButton>(R.id.swu_schoolbus)
        spaceMain = findViewById<ImageButton>(R.id.swu_spaces)
        cafeteriaMain = findViewById<ImageButton>(R.id.swu_cafeteria)
        titleLogo = findViewById<ImageView>(R.id.titleLogo)

        storeMain.setOnClickListener() {
            var intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        ShuttleBusMain.setOnClickListener() {
            var intent = Intent(this, ShuttleBusMainActivity::class.java)
            startActivity(intent)
        }

        spaceMain.setOnClickListener() {
            var intent = Intent(this, Map2Activity::class.java)
            startActivity(intent)
        }

        cafeteriaMain.setOnClickListener() {
            var intent = Intent(this, CafeteriaActivity::class.java)
            startActivity(intent)
        }
    }
}