package com.example.guruapp_1

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
import kotlinx.android.synthetic.main.activity_anniversary50th.*
import kotlinx.android.synthetic.main.activity_library.*
import java.util.*

// 50주년 기념관 - 교내상점
class Anniversary50thActivity : AppCompatActivity() {

    var staff: String = "staff"
    var tous: String = "tous"
    var onigiri: String = "onigiri"
    var gamtan: String = "gamtan"
    var cu: String = "cu"
    var copyworks: String = "copyworks"
    var resetNum: Int = 3
    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    lateinit var onigiriMenu: Button
    lateinit var gamtanMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anniversary50th)

        myHelper = myDBHelper(this, "guruDB", null, 1)

        // DB 조회
        sqlDB = myHelper.readableDatabase
        var cursor: Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + staff + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty_button1.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty_button1.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty_button1.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + tous + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty_button2.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty_button2.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty_button2.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + onigiri + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty_button3.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty_button3.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty_button3.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + gamtan + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty_button4.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty_button4.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty_button4.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + cu + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty_button5.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty_button5.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty_button5.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + copyworks + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty_button6.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty_button6.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty_button6.setBackgroundResource(R.drawable.button_background3)
        }

        // 오니기리와이규동 버튼
        onigiriMenu = findViewById<Button>(R.id.fifty_button3)
        // 감탄떡볶이 버튼
        gamtanMenu = findViewById<Button>(R.id.fifty_button4)

        // 오니기리와이규동 버튼(short click) 선택 시 오니기리와이규동 메뉴(OnigiriActivity)로 전환
        onigiriMenu.setOnClickListener() {
            var intent = Intent(this, OnigiriActivity::class.java)
            startActivity(intent)
        }
        // 감탄떡볶이 버튼(short click) 선택 시 감탄떡볶이 메뉴(GamtanActivity)로 전환
        gamtanMenu.setOnClickListener() {
            var intent = Intent(this, GamtanActivity::class.java)
            startActivity(intent)
        }

        disabledStaff() // 교직원 식당 버튼(long click) 활성화/비활성화 함수
        disabledTouslesjours() // 뚜레쥬르 버튼(long click) 활성화/비활성화 함수
        disabledOnigiri() // 오니기리와이규동 버튼(long click) 활성화/비활성화 함수
        disabledGamtan() // 감탄떡볶이 버튼(long click) 활성화/비활성화 함수
        disabledCU() // CU버튼(long click) 활성화/비활성화 함수
        disabledCopyworks() // 카피웍스 버튼(long click) 활성화/비활성화 함수
    }

    // 교직원식당 운영시간 11:30 - 13:30
    private fun disabledStaff() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 11)
        cal.set(Calendar.MINUTE, 3)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 11:30 이후 버튼 활성화
                registerForContextMenu(fifty_button1)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 13)
        cal.set(Calendar.MINUTE, 3)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                //13:30 이후 버튼 비활성화 및 색 변경
                fifty_button1.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(fifty_button1)
            }
        }, cal.time)
    }

    // 뚜레쥬르 운영시간 7:00 - 18:00
    private fun disabledTouslesjours() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 7)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 7:00 이후 버튼 활성화
                registerForContextMenu(fifty_button2)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:00 이후 버튼 비활성화 및 색 변경
                fifty_button2.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(fifty_button2)
            }
        }, cal.time)
    }

    // 오니기리와이규동 운영시간 11:00 - 18:00
    private fun disabledOnigiri() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 11)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 11:00 이후 버튼 활성화
                registerForContextMenu(fifty_button3)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:00 이후 버튼 비활성화 및 색 변경
                fifty_button3.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(fifty_button3)
            }
        }, cal.time)
    }

    // 감탄떡볶이 운영시간 10:00 - 18:00
    private fun disabledGamtan() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 10)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 10:00 이후 버튼 활성화
                registerForContextMenu(fifty_button4)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                //18:00 이후 버튼 비활성화 및 색 변경
                fifty_button4.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(fifty_button4)
            }
        }, cal.time)
    }

    // CU 운영시간 9:00 - 18:00
    private fun disabledCU() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 9)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 9:00 이후 버튼 활성화
                registerForContextMenu(fifty_button5)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:00 이후 버튼 비활성화 및 색 변경
                fifty_button5.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(fifty_button5)
            }
        }, cal.time)
    }

    // 카피웍스 운영시간 8:30 - 18:30
    private fun disabledCopyworks() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 3)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 8:30 이후 버튼 활성화
                registerForContextMenu(fifty_button6)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 3)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:30 이후 버튼 비활성화 및 색 변경
                fifty_button6.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(fifty_button6)
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
            // 교직원식당 버튼(fifty_button1) 팝업 메뉴 연결
            R.id.fifty_button1 -> {
                menu?.setHeaderTitle("교직원식당 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_staff, menu)
            }
            // 뚜레쥬르 버튼(fifty_button2) 팝업 메뉴 연결
            R.id.fifty_button2 -> {
                menu?.setHeaderTitle("뚜레쥬르 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_touslesjours, menu)
            }
            // 오니기리와이규동 버튼(fifty_button3) 팝업 메뉴 연결
            R.id.fifty_button3 -> {
                menu?.setHeaderTitle("오니기리와이규동 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_onigiri, menu)
            }
            // 감탄떡볶이 버튼(fifty_button4) 팝업 메뉴 연결
            R.id.fifty_button4 -> {
                menu?.setHeaderTitle("감탄떡볶이 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_gamtan, menu)
            }
            // CU버튼 (fifty_button5) 팝업 메뉴 연결
            R.id.fifty_button5 -> {
                menu?.setHeaderTitle("CU 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_cu, menu)
            }
            // 카피웍스 버튼(fifty_button6) 팝업 메뉴 연결
            R.id.fifty_button6 -> {
                menu?.setHeaderTitle("카피웍스 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_copyworks, menu)
            }
        }
    }

    // 혼잡(select1_) 선택 시 -> 붉은색 배경(button_background1)
    // 보통(select2_) 선택 시 -> 노란색 배경(button_background2)
    // 여유(select3_) 선택 시 -> 초록색 배경(button_background3)
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_staff -> {
                fifty_button1.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + staff + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_staff -> {
                fifty_button1.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + staff + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_staff -> {
                fifty_button1.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + staff + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_touslesjours -> {
                fifty_button2.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + tous + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_touslesjours -> {
                fifty_button2.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + tous + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_touslesjours -> {
                fifty_button2.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + tous + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_onigiri -> {
                fifty_button3.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + onigiri + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_onigiri -> {
                fifty_button3.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + onigiri + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_onigiri -> {
                fifty_button3.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + onigiri + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_gamtan -> {
                fifty_button4.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + gamtan + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_gamtan-> {
                fifty_button4.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + gamtan + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_gamtan -> {
                fifty_button4.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + gamtan + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_cu -> {
                fifty_button5.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + cu + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_cu -> {
                fifty_button5.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + cu + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_cu -> {
                fifty_button5.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + cu + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_copyworks -> {
                fifty_button6.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + copyworks + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_copyworks -> {
                fifty_button6.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + copyworks + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_copyworks -> {
                fifty_button6.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + copyworks + "';")
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