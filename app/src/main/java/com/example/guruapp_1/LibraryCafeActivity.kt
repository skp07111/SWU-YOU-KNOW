package com.example.guruapp_1

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_librarycafe.*
import org.w3c.dom.Text
import java.util.*

// 중앙도서관 - 교내상점
class LibraryCafeActivity : AppCompatActivity() {

    var grazie: String = "grazie"
    var resetNum: Int = 3
    lateinit var grazieMenu: Button
    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_librarycafe)

        // 북카페 그라찌에 버튼
        grazieMenu = findViewById<Button>(R.id.libcafe_button1)

        myHelper = myDBHelper(this)

        // 북카페 그라찌에 버튼(short click) 선택 시 북카페 그라찌에 메뉴(GrazieActivity)로 전환
        grazieMenu.setOnClickListener() {
//            sqlDB = myHelper.writableDatabase
//            sqlDB.execSQL("DELETE FROM guruTBL WHERE gName = '" + grazie + "';")
//            Toast.makeText(applicationContext, "삭제됨", Toast.LENGTH_SHORT).show()
//            sqlDB.execSQL("INSERT INTO guruTBL VALUES ( '" + grazie + "' , " + resetNum + ");")
//            Toast.makeText(applicationContext, "입력됨", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, GrazieActivity::class.java)
            startActivity(intent)

        }

        disabledGrazie() // 북카페 그라찌에 버튼(long click) 활성화/비활성화 함수
    }

       // 북카페 그라찌에 운영시간 8:30 - 18:30
       private fun disabledGrazie() {
            val cal = Calendar.getInstance()
                cal.set(Calendar.HOUR_OF_DAY, 8)
                cal.set(Calendar.MINUTE, 30)
                cal.set(Calendar.SECOND, 0)

            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    // 8:30 이후 버튼 활성화
                    registerForContextMenu(libcafe_button1)
                }
            }, cal.time)

           cal.set(Calendar.HOUR_OF_DAY, 18)
           cal.set(Calendar.MINUTE, 30)
           cal.set(Calendar.SECOND, 0)

           timer.schedule(object : TimerTask() {
               override fun run() {
                   // 18:30 이후 버튼 비활성화 및 색 변경
                   libcafe_button1.setBackgroundResource(R.drawable.button_background4)
                   unregisterForContextMenu(libcafe_button1)
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
                // 북카페 그라찌에 버튼(libcafe_button1) 팝업 메뉴 연결
                R.id.libcafe_button1 -> {
                    menu?.setHeaderTitle("북카페 그라찌에 혼잡도")
                    menuInflater.inflate(R.menu.popup_menu_libcafe, menu)
                }
            }
        }

        // 혼잡(select1_) 선택 시 -> 붉은색 배경(button_background1)
        // 보통(select2_) 선택 시 -> 노란색 배경(button_background2)
        // 여유(select3_) 선택 시 -> 초록색 배경(button_background3)
        override fun onContextItemSelected(item: MenuItem): Boolean {
            when (item?.itemId) {
                R.id.select1_libcafe -> {
                    libcafe_button1.setBackgroundResource(R.drawable.button_background1)
                    sqlDB = myHelper.writableDatabase
                    sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + grazie + "';")
                    Toast.makeText(applicationContext, "혼잡", Toast.LENGTH_SHORT).show()
                }
                R.id.select2_libcafe -> {
                    libcafe_button1.setBackgroundResource(R.drawable.button_background2)
                    sqlDB = myHelper.writableDatabase
                    sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 2 + " WHERE gName = '" + grazie + "';")
                    Toast.makeText(applicationContext, "보통", Toast.LENGTH_SHORT).show()
                }
                R.id.select3_libcafe -> {
                    libcafe_button1.setBackgroundResource(R.drawable.button_background3)
                    sqlDB = myHelper.writableDatabase
                    sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 3 + " WHERE gName = '" + grazie + "';")
                    Toast.makeText(applicationContext, "여유", Toast.LENGTH_SHORT).show()
                }
            }
            return super.onContextItemSelected(item)
        }

        private fun setBtnColor() {
            var resetNum: Int = 3
            myHelper = myDBHelper(this)
            sqlDB = myHelper.readableDatabase
            var cursor: Cursor
            cursor = sqlDB.rawQuery("SELECT * FROM guruTBL WHERE gName = '" + grazie + "';",null)

            if (cursor.moveToNext()) {
                resetNum = cursor.getInt(1)
                if (resetNum == 1) libcafe_button1.setBackgroundResource(R.drawable.button_background1)
                else if (resetNum == 2) libcafe_button1.setBackgroundResource(R.drawable.button_background2)
                else if (resetNum == 3) libcafe_button1.setBackgroundResource(R.drawable.button_background3)
            }
        }

        inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "guruDB", null, 1) {
            override fun onCreate(db: SQLiteDatabase?) {
                db!!.execSQL("CREATE TABLE guruTBL (gName CHAR(50) PRIMARY KEY, gNumber INTEGER);")
            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
                db!!.execSQL("DROP TABLE IF EXISTS guruTBL")
                onCreate(db)
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




