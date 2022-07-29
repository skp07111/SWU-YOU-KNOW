package com.example.guruapp_1

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_auditorium.*
import kotlinx.android.synthetic.main.activity_nurigwan.*
import java.util.*

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

        var quiznosMenu = findViewById<Button>(R.id.nuri_button2)
        var gaeunMenu = findViewById<Button>(R.id.nuri_button3)
        var choobapMenu = findViewById<Button>(R.id.nuri_button4)
        var mangwonMenu = findViewById<Button>(R.id.nuri_button12)
        var chegodangMenu = findViewById<Button>(R.id.nuri_button13)
        var etangMenu = findViewById<Button>(R.id.nuri_button14)

        quiznosMenu.setOnClickListener() {
            var intent = Intent(this, QuiznosActivity::class.java)
            startActivity(intent)
        }
        gaeunMenu.setOnClickListener() {
            var intent = Intent(this, GaeunActivity::class.java)
            startActivity(intent)
        }
        choobapMenu.setOnClickListener() {
            var intent = Intent(this, ChoobapActivity::class.java)
            startActivity(intent)
        }
        mangwonMenu.setOnClickListener() {
            var intent = Intent(this, MangwonActivity::class.java)
            startActivity(intent)
        }
        chegodangMenu.setOnClickListener() {
            var intent = Intent(this, ChegodangActivity::class.java)
            startActivity(intent)
        }
        etangMenu.setOnClickListener() {
            var intent = Intent(this, EtangActivity::class.java)
            startActivity(intent)
        }

        registerForContextMenu(nuri_button1)
        registerForContextMenu(nuri_button2)
        registerForContextMenu(nuri_button3)
        registerForContextMenu(nuri_button4)
        registerForContextMenu(nuri_button5)
        registerForContextMenu(nuri_button6)
        registerForContextMenu(nuri_button7)
        registerForContextMenu(nuri_button8)
        registerForContextMenu(nuri_button9)
        registerForContextMenu(nuri_button12)
        registerForContextMenu(nuri_button13)
        registerForContextMenu(nuri_button14)
        disabledGusia()
    }

    private fun disabledGusia() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 19)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                nuri_button12.setBackgroundResource(R.drawable.button_background4)
                nuri_button13.setBackgroundResource(R.drawable.button_background4)
                nuri_button12.setOnClickListener() {
                    false
                }
                nuri_button13.setOnClickListener() {
                    false
                }
                unregisterForContextMenu(nuri_button12)
                unregisterForContextMenu(nuri_button13)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 10)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                nuri_button12.setOnClickListener() {
                    true
                }
                nuri_button13.setOnClickListener() {
                    true
                }
                registerForContextMenu(nuri_button12)
                registerForContextMenu(nuri_button13)
            }
        }, cal.time)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.nuri_button1 -> {
                menu?.setHeaderTitle("비틀쥬스 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_beetlejuice, menu)
            }
            R.id.nuri_button2 -> {
                menu?.setHeaderTitle("퀴즈노스 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_quiznos, menu)
            }
            R.id.nuri_button3 -> {
                menu?.setHeaderTitle("가은 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_gaeun, menu)
            }
            R.id.nuri_button4 -> {
                menu?.setHeaderTitle("츄밥 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_choobap, menu)
            }
            R.id.nuri_button5 -> {
                menu?.setHeaderTitle("우리은행 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_wooribank, menu)
            }
            R.id.nuri_button6 -> {
                menu?.setHeaderTitle("누리스토어 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_nuristore, menu)
            }
            R.id.nuri_button7 -> {
                menu?.setHeaderTitle("안경점 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_optician, menu)
            }
            R.id.nuri_button8 -> {
                menu?.setHeaderTitle("Sweet U 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_sweetu, menu)
            }
            R.id.nuri_button9 -> {
                menu?.setHeaderTitle("우체국 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_postoffice, menu)
            }
            R.id.nuri_button12 -> {
                menu?.setHeaderTitle("만권화밥 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_mangwon, menu)
            }
            R.id.nuri_button13 -> {
            menu?.setHeaderTitle("최고당돈가스 혼잡도")
            menuInflater.inflate(R.menu.popup_menu_choigodang, menu)
            }
            R.id.nuri_button14 -> {
            menu?.setHeaderTitle("에땅 혼잡도")
            menuInflater.inflate(R.menu.popup_menu_etang, menu)
            }
        }
    }

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
}


