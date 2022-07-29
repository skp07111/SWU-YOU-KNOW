package com.example.guruapp_1

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_auditorium.*
import kotlinx.android.synthetic.main.activity_joyegwan.*
import java.util.*

class JoyegwanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joyegwan)
        registerForContextMenu(joye_button1)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.joye_button1 -> {
                menu?.setHeaderTitle("그림나라 화방 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_hwabang, menu)
            }
        }
        disabledHwabang()
    }

    private fun disabledHwabang() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 17)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                joye_button1.setBackgroundResource(R.drawable.button_background4)
                joye_button1.setOnClickListener() {
                    false
                }
                unregisterForContextMenu(joye_button1)
            }
        }, cal.time)

        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 30)
        cal.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                joye_button1.setOnClickListener() {
                    true
                }
                registerForContextMenu(joye_button1)
            }
        }, cal.time)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_hwabang -> joye_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_hwabang -> joye_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_hwabang -> joye_button1.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}




