package com.example.guruapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    lateinit var storeMain: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storeMain = findViewById<Button>(R.id.swu_store)

        storeMain.setOnClickListener() {
            var intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }
}