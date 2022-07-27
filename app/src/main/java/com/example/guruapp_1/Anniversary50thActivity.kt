package com.example.guruapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_anniversary50th.*

class Anniversary50thActivity : AppCompatActivity() {

    lateinit var onigiriMenu: Button
    lateinit var gamtanMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anniversary50th)

        onigiriMenu = findViewById<Button>(R.id.fifty_button3)
        gamtanMenu = findViewById<Button>(R.id.fifty_button4)

        onigiriMenu.setOnClickListener() {
            var intent = Intent(this, OnigiriActivity::class.java)
            startActivity(intent)
        }
        gamtanMenu.setOnClickListener() {
            var intent = Intent(this, GamtanActivity::class.java)
            startActivity(intent)
        }

        registerForContextMenu(fifty_button1)
        registerForContextMenu(fifty_button2)
        registerForContextMenu(fifty_button3)
        registerForContextMenu(fifty_button4)
        registerForContextMenu(fifty_button5)
        registerForContextMenu(fifty_button6)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.fifty_button1 -> {
                menu?.setHeaderTitle("교직원식당 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_staff, menu)
            }
            R.id.fifty_button2 -> {
                menu?.setHeaderTitle("뚜레쥬르 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_touslesjours, menu)
            }
            R.id.fifty_button3 -> {
                menu?.setHeaderTitle("오니기리와이규동 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_onigiri, menu)
            }
            R.id.fifty_button4 -> {
                menu?.setHeaderTitle("감탄떡볶이 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_gamtan, menu)
            }
            R.id.fifty_button5 -> {
                menu?.setHeaderTitle("CU 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_cu, menu)
            }
            R.id.fifty_button6 -> {
                menu?.setHeaderTitle("카피웍스 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_copyworks, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_staff -> fifty_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_staff -> fifty_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_staff -> fifty_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_touslesjours -> fifty_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_touslesjours -> fifty_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_touslesjours -> fifty_button2.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_onigiri -> fifty_button3.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_onigiri -> fifty_button3.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_onigiri -> fifty_button3.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_gamtan -> fifty_button4.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_gamtan-> fifty_button4.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_gamtan -> fifty_button4.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_cu -> fifty_button5.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_cu -> fifty_button5.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_cu -> fifty_button5.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_copyworks -> fifty_button6.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_copyworks -> fifty_button6.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_copyworks -> fifty_button6.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


