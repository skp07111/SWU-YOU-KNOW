package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_anniversary50th.*
import kotlinx.android.synthetic.main.activity_science2.*

class Science2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science2)
        registerForContextMenu(sci2_button1)
        registerForContextMenu(sci2_button2)
        registerForContextMenu(sci2_button3)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.sci2_button1 -> {
                menu?.setHeaderTitle("교직원식당 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_staff, menu)
            }
            R.id.sci2_button2 -> {
                menu?.setHeaderTitle("뚜레쥬르 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_touslesjours, menu)
            }
            R.id.sci2_button3 -> {
                menu?.setHeaderTitle("오니기리와이규동 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_onigiri, menu)
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
        }
        return super.onContextItemSelected(item)
    }
}


