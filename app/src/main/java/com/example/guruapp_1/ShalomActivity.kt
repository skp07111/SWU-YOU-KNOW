package com.example.guruapp_1

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_library.*
import kotlinx.android.synthetic.main.activity_shalom.*
import java.util.*

// 샬롬하우스 - 교내상점
class ShalomActivity : AppCompatActivity() {

    var dorm: String = "dorm"
    var seven: String = "seven"
    var resetNum: Int = 3
    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    lateinit var shalomMenu: Button

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shalom)

        myHelper = myDBHelper(this, "guruDB", null, 1)

        // DB 조회
        sqlDB = myHelper.readableDatabase
        var cursor: Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + dorm + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) shalom_button1.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) shalom_button1.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) shalom_button1.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + seven + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) shalom_button2.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) shalom_button2.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) shalom_button2.setBackgroundResource(R.drawable.button_background3)
        }

        // 기숙사식당 버튼
        shalomMenu = findViewById<Button>(R.id.shalom_button1)

        // 기숙사식당 버튼(short click) 선택 시 기숙사 식당 액티비티(DormitoryCafeteria)로 전환
        shalomMenu.setOnClickListener() {
            var intent = Intent(this, DormitoryCafeteria::class.java)
            startActivity(intent)
        }

        disabledCafeteria() // 기숙사식당 버튼(long click) 활성화/비활성화 함수
        disabledSeven() // 세븐일레븐 버튼(long click) 활성화/비활성화 함수
    }

    // 기숙사식당 운영시간 11:30 - 18:30
    private fun disabledCafeteria() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 11)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 11:30 이후 버튼 활성화
                registerForContextMenu(shalom_button1)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:30 이후 버튼 비활성화 및 색 변경
                shalom_button1.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(shalom_button1)
            }
        }, cal.time)
    }

    // 세븐일레븐 운영시간 8:00 - 20:00
    private fun disabledSeven() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 8:00 이후 버튼 활성화
                registerForContextMenu(shalom_button2)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 20)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 20:00 이후 버튼 비활성화 및 색 변경
                shalom_button2.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(shalom_button2)
            }
        }, cal.time)
    }

    // 혼잡도 버튼 long click 시 팝업 메뉴
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            // 기숙사식당 버튼(shalom_button1) 팝업 메뉴 연결
            R.id.shalom_button1 -> {
                menu?.setHeaderTitle("기숙사식당 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_dorm, menu)
            }
            // 세븐일레븐 버튼(shalom_button2) 팝업 메뉴 연결
            R.id.shalom_button2 -> {
                menu?.setHeaderTitle("세븐일레븐 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_seven, menu)
            }
        }
    }

    // 혼잡(select1_) 선택 시 -> 붉은색 배경(button_background1)
    // 보통(select2_) 선택 시 -> 노란색 배경(button_background2)
    // 여유(select3_) 선택 시 -> 초록색 배경(button_background3)
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_dorm -> {
                shalom_button1.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + dorm + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_dorm -> {
                shalom_button1.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + dorm + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_dorm -> {
                shalom_button1.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + dorm + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_seven -> {
                shalom_button2.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + seven + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_seven -> {
                shalom_button2.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + seven + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_seven -> {
                shalom_button2.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + seven + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
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


