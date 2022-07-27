package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_nurigwan2.*

class Nurigwan2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nurigwan2)
        registerForContextMenu(nuri2_button1)
        registerForContextMenu(nuri2_button2)
        registerForContextMenu(nuri2_button3)
        registerForContextMenu(nuri2_button4)
        registerForContextMenu(nuri2_button5)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.nuri2_button1 -> {
                menu?.setHeaderTitle("5층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_nuri_1, menu)
            }
            R.id.nuri2_button2 -> {
                menu?.setHeaderTitle("6층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_nuri_2, menu)
            }
            R.id.nuri2_button3 -> {
                menu?.setHeaderTitle("7층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_nuri_3, menu)
            }
            R.id.nuri2_button4 -> {
                menu?.setHeaderTitle("인터넷카페 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_nuri_4, menu)
            }
            R.id.nuri2_button5 -> {
                menu?.setHeaderTitle("음악감상실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_nuri_5, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_nuri_1 -> nuri2_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_nuri_1 -> nuri2_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_nuri_1 -> nuri2_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_nuri_2 -> nuri2_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_nuri_2 -> nuri2_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_nuri_2 -> nuri2_button2.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_nuri_3 -> nuri2_button3.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_nuri_3 -> nuri2_button3.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_nuri_3 -> nuri2_button3.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_nuri_4 -> nuri2_button4.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_nuri_4 -> nuri2_button4.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_nuri_4 -> nuri2_button4.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_nuri_5 -> nuri2_button5.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_nuri_5 -> nuri2_button5.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_nuri_5 -> nuri2_button5.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


