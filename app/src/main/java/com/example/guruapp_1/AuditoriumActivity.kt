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
import kotlinx.android.synthetic.main.activity_auditorium.*
import kotlinx.android.synthetic.main.activity_library.*
import kotlinx.android.synthetic.main.activity_librarycafe.*
import java.util.*

// 대강당 - 교내상점

class AuditoriumActivity : AppCompatActivity() {

    var bookstore: String = "bookstore"
    var pandorothy: String = "pandorothy"
    var resetNum: Int = 3
    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    lateinit var pandorothyMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auditorium)

        myHelper = myDBHelper(this, "guruDB", null, 1)

        // DB 조회
        sqlDB = myHelper.readableDatabase
        var cursor: Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + bookstore + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) aud_button1.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) aud_button1.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) aud_button1.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + pandorothy + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) aud_button2.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) aud_button2.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) aud_button2.setBackgroundResource(R.drawable.button_background3)
        }

        // 팬도로시 버튼
        pandorothyMenu = findViewById<Button>(R.id.aud_button2)

        // 팬도로시 버튼(short click) 선택 시 팬도로시 메뉴(PandorothyActivity)로 전환
        pandorothyMenu.setOnClickListener() {
            var intent = Intent(this, PandorothyActivity::class.java)
            startActivity(intent)
        }

        disabledBookstore() // 교내서점 버튼(long click) 활성화/비활성화 함수
        disabledPandorothy() // 팬도로시 버튼(long click) 활성화/비활성화 함수
    }

    // 교내서점 운영시간 8:30 - 17:30
    private fun disabledBookstore() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 8:30 이후 버튼 활성화
                registerForContextMenu(aud_button1)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 17)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 17:30 이후 버튼 비활성화 및 색 변경
                aud_button1.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(aud_button1)
            }
        }, cal.time)
    }

    // 팬도로시 운영시간 8:00 - 18:00
    private fun disabledPandorothy() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 8:00 이후 버튼 활성화
                registerForContextMenu(aud_button2)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:00 이후 버튼 비활성화 및 색 변경
                aud_button2.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(aud_button2)
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
            // 교내서점 버튼(aud_button1) 팝업 메뉴 연결
            R.id.aud_button1 -> {
                menu?.setHeaderTitle("교내서점 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_bookstore, menu)
            }
            // 팬도로시 버튼(aud_button2) 팝업 메뉴 연결
            R.id.aud_button2 -> {
                menu?.setHeaderTitle("팬도로시 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_pandorothy, menu)
            }
        }
    }

    // 혼잡(select1_) 선택 시 -> 붉은색 배경(button_background1)
    // 보통(select2_) 선택 시 -> 노란색 배경(button_background2)
    // 여유(select3_) 선택 시 -> 초록색 배경(button_background3)
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_bookstore -> {
                aud_button1.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + bookstore + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_bookstore -> {
                aud_button1.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + bookstore + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_bookstore -> {
                aud_button1.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + bookstore + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_pandorothy -> {
                aud_button2.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + pandorothy + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_pandorothy -> {
                aud_button2.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + pandorothy + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_pandorothy -> {
                aud_button2.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + pandorothy + "';")
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


