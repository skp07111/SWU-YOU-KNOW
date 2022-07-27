package com.example.guruapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var storeMain: Button
    lateinit var ShuttleBusMain : Button
    lateinit var spaceMain: Button
    lateinit var nurigwanMain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storeMain = findViewById<Button>(R.id.swu_store)
        ShuttleBusMain = findViewById<Button>(R.id.swu_schoolbus)
        spaceMain = findViewById<Button>(R.id.swu_spaces)
        nurigwanMain = findViewById(R.id.nuri_button1)
        nurigwanMain = findViewById(R.id.nuri_button2)
        nurigwanMain = findViewById(R.id.nuri_button3)
        nurigwanMain = findViewById(R.id.nuri_button4)
        nurigwanMain = findViewById(R.id.nuri_button5)
        nurigwanMain = findViewById(R.id.nuri_button6)
        nurigwanMain = findViewById(R.id.nuri_button7)
        nurigwanMain = findViewById(R.id.nuri_button8)
        nurigwanMain = findViewById(R.id.nuri_button9)
        nurigwanMain = findViewById(R.id.nuri_button10)
        nurigwanMain = findViewById(R.id.nuri_button11)
        nurigwanMain = findViewById(R.id.nuri_button12)
        nurigwanMain = findViewById(R.id.nuri_button13)
        nurigwanMain = findViewById(R.id.nuri_button14)

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

        nurigwanMain.setOnClickListener() {
            var intent = Intent(this, NurigwanActivity::class.java)
            startActivity(intent)
        }
    }
}