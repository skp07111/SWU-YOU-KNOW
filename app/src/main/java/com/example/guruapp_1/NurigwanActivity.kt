package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.nurigwan.*

class NurigwanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nurigwan)
        registerForContextMenu(button1)
        registerForContextMenu(button2)
        registerForContextMenu(button3)
        registerForContextMenu(button4)
        registerForContextMenu(button5)
        registerForContextMenu(button6)
        registerForContextMenu(button7)
        registerForContextMenu(button8)
        registerForContextMenu(button9)
        registerForContextMenu(button12)
        registerForContextMenu(button13)
        registerForContextMenu(button14)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.button1 -> {
                menu?.setHeaderTitle("비틀쥬스 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_beetlejuice, menu)
            }
            R.id.button2 -> {
                menu?.setHeaderTitle("퀴즈노스 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_quiznos, menu)
            }
            R.id.button3 -> {
                menu?.setHeaderTitle("가은 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_gaeun, menu)
            }
            R.id.button4 -> {
                menu?.setHeaderTitle("츄밥 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_choobap, menu)
            }
            R.id.button5 -> {
                menu?.setHeaderTitle("우리은행 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_wooribank, menu)
            }
            R.id.button6 -> {
                menu?.setHeaderTitle("누리스토어 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_nuristore, menu)
            }
            R.id.button7 -> {
                menu?.setHeaderTitle("안경점 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_optician, menu)
            }
            R.id.button8 -> {
                menu?.setHeaderTitle("Sweet U 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_sweetu, menu)
            }
            R.id.button9 -> {
                menu?.setHeaderTitle("우체국 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_postoffice, menu)
            }
            R.id.button12 -> {
                menu?.setHeaderTitle("만권화밥 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_mangwon, menu)
            }
            R.id.button13 -> {
            menu?.setHeaderTitle("최고당돈가스 혼잡도")
            menuInflater.inflate(R.menu.popup_menu_choigodang, menu)
            }
            R.id.button14 -> {
            menu?.setHeaderTitle("에땅 혼잡도")
            menuInflater.inflate(R.menu.popup_menu_etang, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_beetlejuice -> button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_beetlejuice -> button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_beetlejuice -> button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_quiznos -> button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_quiznos -> button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_quiznos -> button2.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_gaeun -> button3.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_gaeun -> button3.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_gaeun -> button3.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_choobap -> button4.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_choobap-> button4.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_choobap -> button4.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_wooribank -> button5.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_wooribank -> button5.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_wooribank -> button5.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_nuristore -> button6.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_nuristore -> button6.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_nuristore -> button6.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_optician -> button7.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_optician -> button7.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_optician -> button7.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_sweetu -> button8.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_sweetu -> button8.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_sweetu -> button8.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_postoffice -> button9.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_postoffice -> button9.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_postoffice -> button9.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_mangwon -> button12.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_mangwon -> button12.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_mangwon -> button12.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_choigodang -> button13.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_choigodang -> button13.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_choigodang -> button13.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_etang -> button14.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_etang -> button14.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_etang -> button14.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


