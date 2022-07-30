package com.example.guruapp_1

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_shalom.*
import java.util.*

class ShalomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shalom)

        disabledCafeteria()
        disabledSeven()
    }

    private fun disabledCafeteria() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 11)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                registerForContextMenu(shalom_button1)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 18)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                shalom_button1.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(shalom_button1)
            }
        }, cal.time)
    }

    private fun disabledSeven() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                registerForContextMenu(shalom_button2)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 20)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                shalom_button2.setBackgroundResource(R.drawable.button_background4)
                unregisterForContextMenu(shalom_button2)
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
            R.id.shalom_button1 -> {
                menu?.setHeaderTitle("기숙사식당 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_dorm, menu)
            }
            R.id.shalom_button2 -> {
                menu?.setHeaderTitle("세븐일레븐 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_seven, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_dorm -> shalom_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_dorm -> shalom_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_dorm -> shalom_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_seven -> shalom_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_seven -> shalom_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_seven -> shalom_button2.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


