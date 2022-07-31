package com.example.guruapp_1

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

// 학교공간 맵
class Map2Activity : AppCompatActivity() {

    lateinit var anni2Map: ImageButton
    lateinit var insa2Map: ImageButton
    lateinit var joye2Map: ImageButton
    lateinit var kidokMap: ImageButton
    lateinit var libMap: ImageButton
    lateinit var nuri2Map: ImageButton
    lateinit var sci1Map: ImageButton
    lateinit var sci2Map: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map2)

        anni2Map = findViewById<ImageButton>(R.id.imageButton50_2)
        insa2Map = findViewById<ImageButton>(R.id.imageButtonInsa_2)
        joye2Map = findViewById<ImageButton>(R.id.imageButtonJoye_2)
        kidokMap = findViewById<ImageButton>(R.id.imageButtonKidok_2)
        libMap = findViewById<ImageButton>(R.id.imageButtonLibrary_2)
        nuri2Map = findViewById<ImageButton>(R.id.imageButtonNuri_2)
        sci1Map = findViewById<ImageButton>(R.id.imageButtonSci1_2)
        sci2Map = findViewById<ImageButton>(R.id.imageButtonSci2_2)

        anni2Map.setOnClickListener() {
            var intent = Intent(this, Anniversary50th2Activity::class.java)
            startActivity(intent)
        }
        insa2Map.setOnClickListener() {
            var intent = Intent(this, Insagwan2Activity::class.java)
            startActivity(intent)
        }
        joye2Map.setOnClickListener() {
            var intent = Intent(this, Joyegwan2Activity::class.java)
            startActivity(intent)
        }
        kidokMap.setOnClickListener() {
            var intent = Intent(this, KidokActivity::class.java)
            startActivity(intent)
        }
        libMap.setOnClickListener() {
            var intent = Intent(this, LibraryActivity::class.java)
            startActivity(intent)
        }
        nuri2Map.setOnClickListener() {
            var intent = Intent(this, Nurigwan2Activity::class.java)
            startActivity(intent)
        }
        sci1Map.setOnClickListener() {
            var intent = Intent(this, Science1Activity::class.java)
            startActivity(intent)
        }
        sci2Map.setOnClickListener() {
            var intent = Intent(this, Science2Activity::class.java)
            startActivity(intent)
        }
    }

    // 문의사항 메뉴(map_menu_qna) 연결
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_menu_qna, menu)
        return true
    }

    // 문의사항(action_qna) 선택 시 MapQnaActivity로 전환
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.action_qna -> {
                val intent = Intent(this, MapQnaActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
