package com.example.guruapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

// 메인 화면(홈 화면)
class MainActivity : AppCompatActivity() {
    lateinit var titleLogo : ImageView
    lateinit var cafeteriaMain : ImageButton
    lateinit var storeMain: ImageButton
    lateinit var ShuttleBusMain : ImageButton
    lateinit var spaceMain: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleLogo = findViewById<ImageView>(R.id.titleLogo)

        // 학식메뉴
        cafeteriaMain = findViewById<ImageButton>(R.id.swu_cafeteria)
        // 교내상점
        storeMain = findViewById<ImageButton>(R.id.swu_store)
        // 셔틀버스
        ShuttleBusMain = findViewById<ImageButton>(R.id.swu_schoolbus)
        // 학교공간
        spaceMain = findViewById<ImageButton>(R.id.swu_spaces)

        // 학식메뉴 버튼 선택 시 식당 선택 화면(CafeteriaActivity)으로 전환
        cafeteriaMain.setOnClickListener() {
            var intent = Intent(this, CafeteriaActivity::class.java)
            startActivity(intent)
        }

        // 교내상점 버튼 선택 시 교내상점 맵(MapActivity)으로 전환
        storeMain.setOnClickListener() {
            var intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        // 셔틀버스 버튼 선택 시 버스 시간표(ShuttleBusMainActivity)로 전환
        ShuttleBusMain.setOnClickListener() {
            var intent = Intent(this, ShuttleBusMainActivity::class.java)
            startActivity(intent)
        }

        // 학교공간 버튼 선택 시 학교공간 맵(Map2Activity)으로 전환
        spaceMain.setOnClickListener() {
            var intent = Intent(this, Map2Activity::class.java)
            startActivity(intent)
        }
    }
}