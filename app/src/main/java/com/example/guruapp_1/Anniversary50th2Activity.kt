package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_anniversary50th2.*

class Anniversary50th2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anniversary50th2)
        registerForContextMenu(fifty2_button1)
        registerForContextMenu(fifty2_button2)
        registerForContextMenu(fifty2_button3)
        registerForContextMenu(fifty2_button4)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.fifty2_button1 -> {
                menu?.setHeaderTitle("5층 휴게실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_anni_1, menu)
            }
            R.id.fifty2_button2 -> {
                menu?.setHeaderTitle("4층 휴게실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_anni_2, menu)
            }
            R.id.fifty2_button3 -> {
                menu?.setHeaderTitle("글로벌라운지 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_anni_3, menu)
            }
            R.id.fifty2_button4 -> {
                menu?.setHeaderTitle("3층 휴게실 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_anni_4, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_anni_1 -> fifty2_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_anni_1 -> fifty2_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_anni_1 -> fifty2_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_anni_2 -> fifty2_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_anni_2 -> fifty2_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_anni_2 -> fifty2_button2.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_anni_3 -> fifty2_button3.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_anni_3 -> fifty2_button3.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_anni_3 -> fifty2_button3.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_anni_4 -> fifty2_button4.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_anni_4 -> fifty2_button4.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_anni_4 -> fifty2_button4.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


