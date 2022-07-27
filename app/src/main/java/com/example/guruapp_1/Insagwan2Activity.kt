package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_insagwan2.*

class Insagwan2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insagwan2)
        registerForContextMenu(insa2_button1)
        registerForContextMenu(insa2_button2)
        registerForContextMenu(insa2_button3)
        registerForContextMenu(insa2_button4)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.insa2_button1 -> {
                menu?.setHeaderTitle("3층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_insa_1, menu)
            }
            R.id.insa2_button2 -> {
                menu?.setHeaderTitle("3층 휴게실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_insa_2, menu)
            }
            R.id.insa2_button3 -> {
                menu?.setHeaderTitle("인터넷 카페 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_insa_3, menu)
            }
            R.id.insa2_button4 -> {
                menu?.setHeaderTitle("1층 휴게실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_insa_4, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_insa_1 -> insa2_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_insa_1 -> insa2_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_insa_1 -> insa2_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_insa_2 -> insa2_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_insa_2 -> insa2_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_insa_2 -> insa2_button2.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_insa_3 -> insa2_button3.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_insa_3 -> insa2_button3.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_insa_3 -> insa2_button3.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_insa_4 -> insa2_button4.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_insa_4 -> insa2_button4.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_insa_4 -> insa2_button4.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


