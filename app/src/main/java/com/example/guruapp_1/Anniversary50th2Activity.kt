package com.example.guruapp_1

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_anniversary50th2.*
import kotlinx.android.synthetic.main.activity_library.*

// 50주년 기념관 - 학교공간
class Anniversary50th2Activity : AppCompatActivity() {

    var anni1: String = "anni1"
    var anni2: String = "anni2"
    var anni3: String = "anni3"
    var anni4: String = "anni4"
    var resetNum: Int = 3
    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anniversary50th2)

        myHelper = myDBHelper(this, "guruDB", null, 1)

        // DB 조회
        sqlDB = myHelper.readableDatabase
        var cursor: Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + anni1 + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty2_button1.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty2_button1.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty2_button1.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + anni2 + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty2_button2.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty2_button2.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty2_button2.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + anni3 + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty2_button3.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty2_button3.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty2_button3.setBackgroundResource(R.drawable.button_background3)
        }
        cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + anni4 + "';",null)
        if (cursor.moveToNext()) {
            resetNum = cursor.getInt((cursor.getColumnIndex("gNumber")))
            if (resetNum == 1) fifty2_button4.setBackgroundResource(R.drawable.button_background1)
            else if (resetNum == 2) fifty2_button4.setBackgroundResource(R.drawable.button_background2)
            else if (resetNum == 3) fifty2_button4.setBackgroundResource(R.drawable.button_background3)
        }

        // 혼잡도 버튼 활성화(long click)
        registerForContextMenu(fifty2_button1) // 5층 휴게실 버튼
        registerForContextMenu(fifty2_button2) // 4층 휴게실 버튼
        registerForContextMenu(fifty2_button3) // 글로벌라운지 버튼
        registerForContextMenu(fifty2_button4) // 3층 휴게실 버튼
    }

    // 혼잡도 버튼 long click 시 팝업 메뉴
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            // 5층 휴게실 버튼(fifty2_button1) 팝업 메뉴 연결
            R.id.fifty2_button1 -> {
                menu?.setHeaderTitle("5층 휴게실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_anni_1, menu)
            }
            // 4층 휴게실 버튼(fifty2_button2) 팝업 메뉴 연결
            R.id.fifty2_button2 -> {
                menu?.setHeaderTitle("4층 휴게실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_anni_2, menu)
            }
            // 글로벌라운지 버튼(fifty2_button3) 팝업 메뉴 연결
            R.id.fifty2_button3 -> {
                menu?.setHeaderTitle("글로벌라운지 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_anni_3, menu)
            }
            // 3층 휴게실 버튼(fifty2_button4) 팝업 메뉴 연결
            R.id.fifty2_button4 -> {
                menu?.setHeaderTitle("3층 휴게실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_anni_4, menu)
            }
        }
    }

    // 혼잡(select1_) 선택 시 -> 붉은색 배경(button_background1)
    // 보통(select2_) 선택 시 -> 노란색 배경(button_background2)
    // 여유(select3_) 선택 시 -> 초록색 배경(button_background3)
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_anni_1 -> {
                fifty2_button1.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + anni1 + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_anni_1 -> {
                fifty2_button1.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + anni1 + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_anni_1 -> {
                fifty2_button1.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + anni1 + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_anni_2 -> {
                fifty2_button2.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + anni2 + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_anni_2 -> {
                fifty2_button2.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + anni2 + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_anni_2 -> {
                fifty2_button2.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + anni2 + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_anni_3 -> {
                fifty2_button3.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + anni3 + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_anni_3 -> {
                fifty2_button3.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + anni3 + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_anni_3 -> {
                fifty2_button3.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + anni3 + "';")
                Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
            }
            R.id.select1_anni_4 -> {
                fifty2_button4.setBackgroundResource(R.drawable.button_background1)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + anni4 + "';")
                Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_anni_4 -> {
                fifty2_button4.setBackgroundResource(R.drawable.button_background2)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + anni4 + "';")
                Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
            }
            R.id.select3_anni_4 -> {
                fifty2_button4.setBackgroundResource(R.drawable.button_background3)
                sqlDB = myHelper.writableDatabase
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + anni4 + "';")
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


