package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_joyegwan.*

class Joyegwan2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joyegwan2)
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




