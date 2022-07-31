package com.example.guruapp_1

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_auditorium.*
import kotlinx.android.synthetic.main.activity_nurigwan.*
import java.util.*

// 학생누리관 - 교내상점
class NurigwanActivity : AppCompatActivity() {

    lateinit var quiznosMenu: Button
    lateinit var gaeunMenu: Button
    lateinit var choobapMenu: Button
    lateinit var mangwonMenu: Button
    lateinit var chegodangMenu: Button
    lateinit var etangMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nurigwan)

        // 퀴즈노스 버튼
        var quiznosMenu = findViewById<Button>(R.id.nuri_button2)
        // 가은 버튼
        var gaeunMenu = findViewById<Button>(R.id.nuri_button3)
        // 츄밥 버튼
        var choobapMenu = findViewById<Button>(R.id.nuri_button4)
        // 만권화밥 버튼
        var mangwonMenu = findViewById<Button>(R.id.nuri_button12)
        // 최고당돈가스 버튼
        var chegodangMenu = findViewById<Button>(R.id.nuri_button13)
        // 에땅 버튼
        var etangMenu = findViewById<Button>(R.id.nuri_button14)

        // 퀴즈노스 버튼(short click) 선택 시 퀴즈노스 메뉴(QuiznosActivity)로 전환
        quiznosMenu.setOnClickListener() {
            var intent = Intent(this, QuiznosActivity::class.java)
            startActivity(intent)
        }
        // 가은 버튼(short click) 선택 시 가은 메뉴(GaeunActivity)로 전환
        gaeunMenu.setOnClickListener() {
            var intent = Intent(this, GaeunActivity::class.java)
            startActivity(intent)
        }
        // 츄밥 버튼(short click) 선택 시 츄밥 메뉴(ChoobapActivity)로 전환
        choobapMenu.setOnClickListener() {
            var intent = Intent(this, ChoobapActivity::class.java)
            startActivity(intent)
        }
        // 만권화밥 버튼(short click) 선택 시 만권화밥 메뉴(MangwonActivity)로 전환
        mangwonMenu.setOnClickListener() {
            var intent = Intent(this, MangwonActivity::class.java)
            startActivity(intent)
        }
        // 최고당돈가스 버튼(short click) 선택 시 최고당돈가스 메뉴(ChegodangActivity)로 전환
        chegodangMenu.setOnClickListener() {
            var intent = Intent(this, ChegodangActivity::class.java)
            startActivity(intent)
        }
        // 에땅 버튼(short click) 선택 시 에땅 메뉴(EtangActivity)로 전환
        etangMenu.setOnClickListener() {
            var intent = Intent(this, EtangActivity::class.java)
            startActivity(intent)
        }

        // 혼잡도 버튼 활성화(long click)
        registerForContextMenu(nuri_button5) // 우리은행 버튼
        registerForContextMenu(nuri_button9) // 우체국 버튼

        disabledQuiznos() // 퀴즈노스 버튼(long click) 활성화/비활성화 함수
        disabledCafe() // 비틀쥬스, 가은 버튼(long click) 활성화/비활성화 함수
        disabledChoobap() // 츄밥 버튼(long click) 활성화/비활성화 함수
        disabledNuristore() // 누리스토어 버튼(long click) 활성화/비활성화 함수
        disabledGlass() // 안경점 버튼(long click) 활성화/비활성화 함수
        disabledSweetu() // Sweet U 버튼(long click) 활성화/비활성화 함수
        disabledGusia() // 만권화밥, 최고당돈가스 버튼(long click) 활성화/비활성화 함수
        disabledEtang() // 에땅 버튼(long click) 활성화/비활성화 함수

    }

    // 퀴즈노스 운영시간 8:00 - 18:30
    private fun disabledQuiznos() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 8:00 이후 버튼 활성화
                registerForContextMenu(nuri_button2)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:00 이후 버튼 비활성화 및 색 변경
                nuri_button2.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(nuri_button2)
            }
        }, cal.time)
    }

    // 비틀쥬스, 가은 운영시간 8:00 - 18:00
    private fun disabledCafe() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 8:00 이후 버튼 활성화
                registerForContextMenu(nuri_button1)
                registerForContextMenu(nuri_button3)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:00 이후 버튼 비활성화 및 색 변경
                nuri_button1.setBackgroundResource(R.drawable.button_background4)
                nuri_button3.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(nuri_button1)
                unregisterForContextMenu(nuri_button3)
            }
        }, cal.time)
    }

    // 츄밥 운영시간 11:00 - 15:00
    private fun disabledChoobap() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 11)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 11:00 이후 버튼 활성화
                registerForContextMenu(nuri_button4)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 15)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 15:00 이후 버튼 비활성화 및 색 변경
                nuri_button4.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(nuri_button4)
            }
        }, cal.time)
    }

    // 누리스토어 운영시간 8:30 - 18:00
    private fun disabledNuristore() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 8:30 이후 버튼 활성화
                registerForContextMenu(nuri_button6)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:00 이후 버튼 비활성화 및 색 변경
                nuri_button6.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(nuri_button6)
            }
        }, cal.time)
    }

    // 안경점 운영시간 9:00 - 18:00
    private fun disabledGlass() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 9)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 9:00 이후 버튼 활성화
                registerForContextMenu(nuri_button7)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 18:00 이후 버튼 비활성화 및 색 변경
                nuri_button7.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(nuri_button7)
            }
        }, cal.time)
    }

    // SweetU 운영시간 10:00 - 17:30
    private fun disabledSweetu() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 10)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 10:00 이후 버튼 활성화
                registerForContextMenu(nuri_button8)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 17)
        cal.set(Calendar.MINUTE, 3)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 17:30 이후 버튼 비활성화 및 색 변경
                nuri_button8.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(nuri_button8)
            }
        }, cal.time)
    }

    // 만권화밥, 최고당돈가스 운영시간 10:00 - 19:00
    private fun disabledGusia() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 10)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 10:00 이후 버튼 활성화
                registerForContextMenu(nuri_button12)
                registerForContextMenu(nuri_button13)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 19)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 19:00 이후 버튼 비활성화 및 색 변경
                nuri_button12.setBackgroundResource(R.drawable.button_background4)
                nuri_button13.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(nuri_button12)
                unregisterForContextMenu(nuri_button13)
            }
        }, cal.time)
    }

    // 에땅 운영시간 10:00 - 17:00
    private fun disabledEtang() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 10)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // 10:00 이후 버튼 활성화
                registerForContextMenu(nuri_button14)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 17)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                // 17:00 이후 버튼 비활성화 및 색 변경
                nuri_button14.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(nuri_button14)
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
            // 비틀쥬스 버튼(nuri_button1) 팝업 메뉴 연결
            R.id.nuri_button1 -> {
                menu?.setHeaderTitle("비틀쥬스 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_beetlejuice, menu)
            }
            // 퀴즈노스 버튼(nuri_button2) 팝업 메뉴 연결
            R.id.nuri_button2 -> {
                menu?.setHeaderTitle("퀴즈노스 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_quiznos, menu)
            }
            // 가은 버튼(nuri_button3) 팝업 메뉴 연결
            R.id.nuri_button3 -> {
                menu?.setHeaderTitle("가은 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_gaeun, menu)
            }
            // 츄밥 버튼(nuri_button4) 팝업 메뉴 연결
            R.id.nuri_button4 -> {
                menu?.setHeaderTitle("츄밥 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_choobap, menu)
            }
            // 우리은행 버튼(nuri_button5) 팝업 메뉴 연결
            R.id.nuri_button5 -> {
                menu?.setHeaderTitle("우리은행 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_wooribank, menu)
            }
            // 누리스토어 버튼(nuri_button6) 팝업 메뉴 연결
            R.id.nuri_button6 -> {
                menu?.setHeaderTitle("누리스토어 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_nuristore, menu)
            }
            // 안경점 버튼(nuri_button7) 팝업 메뉴 연결
            R.id.nuri_button7 -> {
                menu?.setHeaderTitle("안경점 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_optician, menu)
            }
            // SweetU 버튼(nuri_button8) 팝업 메뉴 연결
            R.id.nuri_button8 -> {
                menu?.setHeaderTitle("Sweet U 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_sweetu, menu)
            }
            // 우체국 버튼(nuri_button9) 팝업 메뉴 연결
            R.id.nuri_button9 -> {
                menu?.setHeaderTitle("우체국 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_postoffice, menu)
            }
            // 만권화밥 버튼(nuri_button12) 팝업 메뉴 연결
            R.id.nuri_button12 -> {
                menu?.setHeaderTitle("만권화밥 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_mangwon, menu)
            }
            // 최고당돈가스 버튼(nuri_button13) 팝업 메뉴 연결
            R.id.nuri_button13 -> {
            menu?.setHeaderTitle("최고당돈가스 혼잡도")
            menuInflater.inflate(R.menu.popup_menu_choigodang, menu)
            }
            // 에땅 버튼(nuri_button14) 팝업 메뉴 연결
            R.id.nuri_button14 -> {
            menu?.setHeaderTitle("에땅 혼잡도")
            menuInflater.inflate(R.menu.popup_menu_etang, menu)
            }
        }
    }

    // 혼잡(select1_) 선택 시 -> 붉은색 배경(button_background1)
    // 보통(select2_) 선택 시 -> 노란색 배경(button_background2)
    // 여유(select3_) 선택 시 -> 초록색 배경(button_background3)
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_beetlejuice -> nuri_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_beetlejuice -> nuri_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_beetlejuice -> nuri_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_quiznos -> nuri_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_quiznos -> nuri_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_quiznos -> nuri_button2.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_gaeun -> nuri_button3.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_gaeun -> nuri_button3.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_gaeun -> nuri_button3.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_choobap -> nuri_button4.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_choobap-> nuri_button4.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_choobap -> nuri_button4.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_wooribank -> nuri_button5.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_wooribank -> nuri_button5.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_wooribank -> nuri_button5.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_nuristore -> nuri_button6.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_nuristore -> nuri_button6.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_nuristore -> nuri_button6.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_optician -> nuri_button7.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_optician -> nuri_button7.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_optician -> nuri_button7.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_sweetu -> nuri_button8.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_sweetu -> nuri_button8.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_sweetu -> nuri_button8.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_postoffice -> nuri_button9.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_postoffice -> nuri_button9.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_postoffice -> nuri_button9.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_mangwon -> nuri_button12.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_mangwon -> nuri_button12.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_mangwon -> nuri_button12.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_choigodang -> nuri_button13.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_choigodang -> nuri_button13.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_choigodang -> nuri_button13.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_etang -> nuri_button14.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_etang -> nuri_button14.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_etang -> nuri_button14.setBackgroundResource(R.drawable.button_background3)
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


