package com.example.guruapp_1

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_anniversary50th.*
import kotlinx.android.synthetic.main.activity_library.*
import java.util.*

// 중앙도서관 - 학교공간
class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        disabledJaryosil() // 2,3,4층 주제자료실 & 5층 슈니나래 버튼 (long click) 활성화/비활성화 함수
        disabledFloor1() // 1층 모든 버튼 (long click) 활성화/비활성화 함수
    }

    // 주제자료실 운영시간 9:00 - 20:00
    private fun disabledJaryosil() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 9)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 9:00 이후 버튼 활성화
                registerForContextMenu(lib_button1)
                registerForContextMenu(lib_button2)
                registerForContextMenu(lib_button3)
                registerForContextMenu(lib_button4)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 20)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 20:00 이후 버튼 비활성화 및 색 변경
                lib_button1.setBackgroundResource(R.drawable.button_background4)
                lib_button2.setBackgroundResource(R.drawable.button_background4)
                lib_button3.setBackgroundResource(R.drawable.button_background4)
                lib_button4.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(lib_button1)
                unregisterForContextMenu(lib_button2)
                unregisterForContextMenu(lib_button3)
                unregisterForContextMenu(lib_button4)
            }
        }, cal.time)
    }

    // 도서관 1층 운영시간 8:00 - 23:00
    private fun disabledFloor1() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 8:00 이후 버튼 활성화
                registerForContextMenu(lib_button5)
                registerForContextMenu(lib_button6)
                registerForContextMenu(lib_button7)
                registerForContextMenu(lib_button8)
                registerForContextMenu(lib_button9)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 23)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 23:00 이후 버튼 비활성화 및 색 변경
                lib_button5.setBackgroundResource(R.drawable.button_background4)
                lib_button6.setBackgroundResource(R.drawable.button_background4)
                lib_button7.setBackgroundResource(R.drawable.button_background4)
                lib_button8.setBackgroundResource(R.drawable.button_background4)
                lib_button9.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(lib_button5)
                unregisterForContextMenu(lib_button6)
                unregisterForContextMenu(lib_button7)
                unregisterForContextMenu(lib_button8)
                unregisterForContextMenu(lib_button9)
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
            // 2층 주제자료실 버튼(lib_button1) 팝업 메뉴 연결
            R.id.lib_button1 -> {
                menu?.setHeaderTitle("2층 주제자료실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_1, menu)
            }
            // 3층 주제자료실 버튼(lib_button2) 팝업 메뉴 연결
            R.id.lib_button2 -> {
                menu?.setHeaderTitle("3층 주제자료실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_2, menu)
            }
            // 4층 주제자료실 버튼(lib_button3) 팝업 메뉴 연결
            R.id.lib_button3 -> {
                menu?.setHeaderTitle("4층 주제자료실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_3, menu)
            }
            // 5층 슈니나래 버튼(lib_button4) 팝업 메뉴 연결
            R.id.lib_button4 -> {
                menu?.setHeaderTitle("5층 슈니나래 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_4, menu)
            }
            // 소셜러닝라운지 버튼(lib_button5) 팝업 메뉴 연결
            R.id.lib_button5 -> {
                menu?.setHeaderTitle("소셜러닝라운지 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_5, menu)
            }
            // 멀티미디어라운지 버튼(lib_button6) 팝업 메뉴 연결
            R.id.lib_button6 -> {
                menu?.setHeaderTitle("멀티미디어라운지 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_6, menu)
            }
            // 커뮤니티라운지 버튼(lib_button7) 팝업 메뉴 연결
            R.id.lib_button7 -> {
                menu?.setHeaderTitle("커뮤니티라운지 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_7, menu)
            }
            // 슈니마루 버튼(lib_button8) 팝업 메뉴 연결
            R.id.lib_button8 -> {
                menu?.setHeaderTitle("슈니마루 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_8, menu)
            }
            // 멀티플렉스존 버튼(lib_button9) 팝업 메뉴 연결
            R.id.lib_button9 -> {
                menu?.setHeaderTitle("멀티플렉스존 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_9, menu)
            }
        }
    }

    // 혼잡(select1_) 선택 시 -> 붉은색 배경(button_background1)
    // 보통(select2_) 선택 시 -> 노란색 배경(button_background2)
    // 여유(select3_) 선택 시 -> 초록색 배경(button_background3)
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_lib_1 -> lib_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_lib_1 -> lib_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_lib_1 -> lib_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_lib_2 -> lib_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_lib_2 -> lib_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_lib_2 -> lib_button2.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_lib_3 -> lib_button3.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_lib_3 -> lib_button3.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_lib_3 -> lib_button3.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_lib_4 -> lib_button4.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_lib_4 -> lib_button4.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_lib_4 -> lib_button4.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_lib_5 -> lib_button5.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_lib_5 -> lib_button5.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_lib_5 -> lib_button5.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_lib_6 -> lib_button6.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_lib_6 -> lib_button6.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_lib_6 -> lib_button6.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_lib_7 -> lib_button7.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_lib_7 -> lib_button7.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_lib_7 -> lib_button7.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_lib_8 -> lib_button8.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_lib_8 -> lib_button8.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_lib_8 -> lib_button8.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_lib_9 -> lib_button9.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_lib_9 -> lib_button9.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_lib_9 -> lib_button9.setBackgroundResource(R.drawable.button_background3)
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




