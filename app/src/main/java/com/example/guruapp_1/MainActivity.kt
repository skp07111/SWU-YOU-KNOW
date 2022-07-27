package com.example.guruapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var storeMain: Button
    lateinit var ShuttleBusMain : Button
    lateinit var spaceMain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storeMain = findViewById<Button>(R.id.swu_store)
        ShuttleBusMain = findViewById<Button>(R.id.swu_schoolbus)
        spaceMain = findViewById<Button>(R.id.swu_spaces)

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
    }
}