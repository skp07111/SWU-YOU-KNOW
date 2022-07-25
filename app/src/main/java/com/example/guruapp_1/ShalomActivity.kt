package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_shalom.*

class ShalomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shalom)
        registerForContextMenu(shalom_button1)
        registerForContextMenu(shalom_button2)
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


