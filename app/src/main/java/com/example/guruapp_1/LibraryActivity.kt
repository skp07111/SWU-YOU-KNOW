package com.example.guruapp_1

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_anniversary50th.*
import kotlinx.android.synthetic.main.activity_library.*
import java.util.*

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        disabledJaryosil()
        disabledFloor1()
    }

    private fun disabledJaryosil() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 9)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
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

    private fun disabledFloor1() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
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

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.lib_button1 -> {
                menu?.setHeaderTitle("2층 주제자료실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_1, menu)
            }
            R.id.lib_button2 -> {
                menu?.setHeaderTitle("3층 주제자료실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_2, menu)
            }
            R.id.lib_button3 -> {
                menu?.setHeaderTitle("4층 주제자료실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_3, menu)
            }
            R.id.lib_button4 -> {
                menu?.setHeaderTitle("5층 슈니나래 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_4, menu)
            }
            R.id.lib_button5 -> {
                menu?.setHeaderTitle("소셜러닝라운지 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_5, menu)
            }
            R.id.lib_button6 -> {
                menu?.setHeaderTitle("멀티미디어라운지 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_6, menu)
            }
            R.id.lib_button7 -> {
                menu?.setHeaderTitle("커뮤니티라운지 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_7, menu)
            }
            R.id.lib_button8 -> {
                menu?.setHeaderTitle("슈니마루 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_8, menu)
            }
            R.id.lib_button9 -> {
                menu?.setHeaderTitle("멀티플렉스존 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_lib_9, menu)
            }
        }
    }

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
}




